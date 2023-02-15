interface Student {
  name: string;
  age: number;
}


const student1: Student = {age: 0, name: ""};

const student2: Partial<Student> = {};

export const student3: Record<string, any> = {
  name: "张三",
  age: 20,
};