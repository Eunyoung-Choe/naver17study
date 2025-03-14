package day1224;

// 320p
//class Vehicle // 일반 클래스 body 필요없음.
//{
//	public void run()
//	{
//		System.out.println("차량이 달립니다.");
//	}
//}


//abstract class Vehicle // abstract 클래스에는 일반/추상 메서드 모두 올 수 있음.
//{
//	public abstract void run();
//}


// ↑ 근데 추상메서드만 있으니까 interface로 변경 가능
interface Vehicle
{
	public void run();
}



class Bus implements Vehicle
{
	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
	}
}

class Taxi implements Vehicle
{
	@Override
	public void run()
	{
		System.out.println("택시가 달립니다.");
	}
}

class Driver
{
	// 매개변수 다형성 
	public void drive(Vehicle vehicle)
	{
		vehicle.run();
	}
}

/*================================================*/
public class Book322 {

	public static void main(String[] args) {

		Driver driver = new Driver();
		
		Bus bus = new Bus();
		driver.drive(bus);
		
		Taxi taxi = new Taxi();
		driver.drive(taxi);
	}

}
