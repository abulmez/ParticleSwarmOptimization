package entity;

import java.util.ArrayList;

public class Population {
    private ArrayList<Chromosome> population;
    private Integer bestPosition;

    public  Population(){
        population = new ArrayList<>();
        bestPosition = -1;
    }

    public void addChromosome(Chromosome c){
        population.add(c);
    }

    public ArrayList<Chromosome> getChromosomesList(){
        return population;
    }

    public Chromosome getChromosome(Integer position){
        return population.get(position);
    }

    public Integer getBestPosition() {
        return bestPosition;
    }

    public void setBestPosition(Integer bestPosition) {
        this.bestPosition = bestPosition;
    }
}
