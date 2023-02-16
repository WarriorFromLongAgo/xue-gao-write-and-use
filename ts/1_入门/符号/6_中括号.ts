interface Image1 {
  keyId: string;
}

// 物料左侧数据
interface Image2 {
  [propName: string]: Array<Image1>;
}

let tempImageV1: Image2 = {
  One: [
    {
      keyId: "one 1",
    },
    {
      keyId: "one 2",
    },
  ],
  Two: [
    {
      keyId: "two 1",
    },
  ],
};

for (let tempImageV1Key in tempImageV1) {
  console.log(tempImageV1Key);
  console.log(tempImageV1[tempImageV1Key]);
}







