let path = "694be3e6-e3c4-3a03-a834-32e04d70b6a0.json";
const data = require("./" + path)

var fs = require('fs');

console.log(JSON.stringify(data, "", "\t"));

let task_3319 = 3319;
let task_3273 = 3273;

let oneJson = data['questProgress:9'];
for (var val in oneJson) {
  // console.log(" val = ", JSON.stringify(oneJson[val]));
  let temp = oneJson[val]['questID:3'];
  if (temp < task_3273) {
    continue
  }
  if (temp == task_3319) {
    console.log(" task_3319 = ", JSON.stringify(oneJson[val]));
    continue;
  }
  console.log(" temp = ", JSON.stringify(oneJson[val]));
  let newTemp = temp + 6000;
  oneJson[val]['questID:3'] = newTemp;
  console.log(" temp = ", JSON.stringify(oneJson[val]));
}

console.log(JSON.stringify(data, "", "\t"));

fs.writeFile("./" + "fjm_" + path, JSON.stringify(data, "", "\t"), (error) => {
  if (error) {
    console.log('An error has occurred ', error);
    return;
  }
  console.log('Data written successfully to disk');
});



