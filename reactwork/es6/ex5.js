let obj1 = {"name": "lee", "age": 23, "addr": "seoul"};
console.log(obj1.name);
console.log(obj1.age);
console.log(obj1.addr);

// 오브젝트 통으로 대입
let obj2 = obj1;

let {name,age} = obj2; // 한 번에 담을 수 있다는 점
console.log("name=" + name);
console.log("age=" + age);

// 함수 
let f1 = ({name='수지', age=20}={}) => console.log("이름="+name+", age="+age); // ={}: 초기값

// 호출
f1();
f1(obj2.name);
f1(obj1);