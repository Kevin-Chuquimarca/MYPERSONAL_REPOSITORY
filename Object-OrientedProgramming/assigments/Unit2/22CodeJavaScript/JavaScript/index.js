const Chicken = require('./Chicken');
const Cow = require('./Cow');

const chicken = new Chicken(1, "Ponedora", 30);
    console.log(chicken.toString());
    console.log('spent food in the', 5 ,'month:',chicken.eatAnimal(42.2, 5));
const cow = new Cow(2,"heiland",70);
    console.log(cow.toString());
    console.log('spent food in the', 5 ,'month:',chicken.eatAnimal(240.25, 2));

