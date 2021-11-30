numGuesser = (...args) => {
  return args.filter((num) => num === 1);
};

console.log(numGuesser(1, 1, 4, 5, 6, 1, 1));

//copying objects
const person = {
  name: "JJ",
};

const p2 = {
  ...person,
};

console.log(p2);

//map function
const numbers = [1,2,3];

const doubleArray = numbers.map((num) => {
    return num*2
})

console.log(numbers);
console.log(doubleArray);