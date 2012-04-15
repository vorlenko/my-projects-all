public class Type1 extends ItemClass {

	public Type1(){}
	
	String name;
	public Type1(String name,int i){
		this.name=name;
		this.i=i;
	}
	
	int i;
	
	public void out(){
		System.out.println("Type1");
	}
}
