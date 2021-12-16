package main;

import animal.*;
import veterinario.Veterinario;
import zoologico.Zoologico;

class Principal {

    public static void main(String[] args) {

        {
            Zoologico zoologico = new Zoologico();
            zoologico.jaulas.add(new Cachorro("Rex",1));
            zoologico.jaulas.add(new Cavalo("Pé-de-Pano",1));
            zoologico.jaulas.add(new Preguica("Soneca",1));
            zoologico.jaulas.add(new Cachorro("Tobby",2));
            zoologico.jaulas.add(new Cavalo("Trovão",2));
            zoologico.jaulas.add(new Preguica("Toin",2));
            zoologico.jaulas.add(new Cachorro("Pipo",3));
            zoologico.jaulas.add(new Cavalo("Alípio",3));
            zoologico.jaulas.add(new Preguica("Relaxo",3));
            zoologico.jaulas.add(new Cachorro("Spike",4));
        }

        for(Animal animal:Zoologico.jaulas){
            animal.emitirSom();
            if(animal instanceof Cachorro||animal instanceof Cavalo){
                ((MovimentacaoAnimal) animal).correr();
            }
        }


    }
}
