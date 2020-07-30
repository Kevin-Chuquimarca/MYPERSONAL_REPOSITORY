const FarmAnimal = require('./FarmAnimal');

class Cow extends FarmAnimal {
    #litersOfMilk;

    constructor(id,breed,litersOfMilk){
        super(id, breed);
        this.#litersOfMilk = litersOfMilk;
    }
    
    eatAnimal(food, months){
     
        return food * months;
    }

    getLitersOfMilk(){
        return this.#litersOfMilk;
    }

    toString(){
       return `Cow{id=${this.getId()}, breed=${this.getBreed()}, litersOfMilk=${this.getLitersOfMilk()}}`;
    }
}

module.exports = Cow;