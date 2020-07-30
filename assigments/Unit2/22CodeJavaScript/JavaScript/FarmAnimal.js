class FarmAnimal {
    #id;
    #breed;

    constructor(id,breed){
        this.#id = id;
        this.#breed = breed;
    }    

    eatAnimal(){
    }
    
    getId(){
        return this.#id;
    }

    getBreed(){
        return this.#breed;
    }
}

module.exports = FarmAnimal;