class listOfRecords
    {
            private String firstName;
            private String lastName;
            private String phoneNum;     
         
      //constructor
            public listOfRecords(String f, String l, String n)
            {
                    firstName=f;
                    lastName=l;
                    phoneNum=formatPhone(n);     
            }
   
      public String getFirst()
      {
        return firstName;
      }
   
      public String getLast()
      {
        return lastName;
      }
   
      public String getNumber()
      {
        return phoneNum;
      }
   
      public void changePhone(String p)
      {
        phoneNum=formatPhone(p);
      }
   
      public void changeFirst(String f)
      {
        firstName=f;
      }
   
      public void changeLast(String l)
      {
        lastName=l;
      }
   
   
      public String toString()
      {
        return firstName +"\t\t"+ lastName +"\t\t"+phoneNum;
      }
         
        public String formatPhone(String num)
            {
        return num.substring(0,3)+"-"+num.substring(3,6)+"-"+num.substring(6,10);
      }
}