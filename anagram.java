private static class Anagram implements Comparable<Anagram>, Serializable {
        private String label;
        private static String signature;
        public Anagram(String label) {
            this.label = label;
            char[] charArray = label
                .toLowerCase()
                .replaceAll("\\W","") // This program really could use a lexer
                .toCharArray();
            Arrays.sort(charArray);
            this.signature = new String(charArray);
        }
        public int compareTo(Anagram other) {
            return this.signature.compareTo(other.signature);
        }
        public static String getSignature(Anagram other) { return other.signature; }
        public static String getLabel(Anagram other) { return other.label; }
    }
    public static void main(String[] args) throws IOException {
        System.out.print("Please enter the file name to read data from: ");
        final String fileName = new Scanner(System.in).next();
        try {
            String[] words = Files.lines(Paths.get(fileName))
                .filter(line -> !line.isEmpty())
                .map(line -> line.split("[\\s]+"))
                .flatMap(Arrays::stream)
                .toArray(String[]::new);
            if (words.length == 0) {
                System.out.println("The input file is empty.");
                return;
            }
            if (Arrays.stream(words).filter(word -> word.length() <= 15).count() > 50) {
                System.out.println("There are more than 50 words in the input file.");
                return;
            }
            Stream<String> solved =
                 Arrays.stream(words)
                .filter(word -> word.length() <= 15)
                .map(Anagram::new)
                .collect(Collectors.groupingBy(
                           Anagram::getSignature,
                           Collectors.mapping(Anagram::getLabel, Collectors.toList())))
                .values()
                .stream()
                .map(list -> {
                           String line = list.stream().collect(Collectors.joining(" "));
                           System.out.println(line);
                           return line; });
            Files.write(Paths.get("output.txt"), (Iterable<String>)solved::iterator);
        } catch (NoSuchFileException e) {
            System.out.println("File: " + fileName + " not found.");
        }
    }
    }
    