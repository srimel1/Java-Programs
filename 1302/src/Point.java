
public class Point {
	private int x;
	private int y;
	
	//sort by x and break ties by y
	public int compareTo(Point other) {
		if(x < other.x) {
			return -1;
		}else if(x>other.x) {
			return 1;
		}else if(y<other.y) {
			return -1;
		}else if(y>other.y) {
			return 1;
		}else{
			return 0;
		}
	}
	public int comparTo2(Point other) {
		if(x!= other.x) {
			return x - other.x;
			
		}else {
			return y - other.y;
		}
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
