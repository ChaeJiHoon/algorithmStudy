const fs = require("fs");
const num = parseInt(fs.readFileSync("/dev/stdin").toString().trim());

let sum = 0;

for(let i=1;i<=num;i++){
    sum += i;
}

console.log(sum);