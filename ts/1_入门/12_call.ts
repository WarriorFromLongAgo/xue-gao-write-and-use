class Dong {
  name: string;

  constructor() {
    this.name = "dong 1";
  }

  hello() {
    return "hell, " + this.name;
  }
}

const dong1 = new Dong();
let hello1 = dong1.hello();
console.log(" 1 ", hello1);

let call1 = dong1.hello.call({xxx: 2});
console.log(" 2 ", call1);

let apply1 = dong1.hello.apply({xxx: 1});
console.log(" 3 ", apply1);
