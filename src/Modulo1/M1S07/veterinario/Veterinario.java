package veterinario;

import animal.Animal;

public class Veterinario {

    public Veterinario(){
    }

    public void examinar(Animal animal){
        System.out.println("Examinando "+animal.getNome());
        animal.emitirSom();
    }
}
