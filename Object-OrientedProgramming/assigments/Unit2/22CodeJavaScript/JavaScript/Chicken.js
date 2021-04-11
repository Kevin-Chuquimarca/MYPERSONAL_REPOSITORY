const FarmAnimal = require('./FarmAnimal');

class Chicken extends FarmAnimal {
    #eggs;

    constructor(id,breed,eggs){
        super(id, breed);
        this.#eggs = eggs;
    }
    
    eatAnimal(food, months){
     
        return food * months;
    }

    getEggs(){
        return this.#eggs;
    }

    toString(){
       return `Chicken{id=${this.getId()}, breed=${this.getBreed()}, eggs=${this.getEggs()}}`;
    }
}

module.exports = Chicken;