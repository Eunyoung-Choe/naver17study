package day1227;

// p.704 - Workable, Speakable, Person

@FunctionalInterface
interface Workable
{
	void work(String name, String job);
}

// Speackable
interface Speakable
{
	void speak(String content);
}

// p.705 - Person
class Person
{
	public void action1(Workable workable)
	{
		workable.work("최은영", "프로그래밍");
	}
	
	public void action2(Speakable speakable)
	{
		speakable.speak("안녕하세요.");
	}
}


public class Book705 { // p.705 LambdaExample

	public static void main(String[] args) {

		Person person = new Person();
		
		person.action1((name, job) ->{
			System.out.println(name+" 이 ");
			System.out.println(job+" 을 합니다.");
		});
		
		person.action2(word->{
			System.out.println("\""+word+"\"");
			System.out.println("라고 말합니다.");
		});
		
		person.action2(word -> System.out.println("\""+word+"\" 하고 외칩니다."));
	}

}
