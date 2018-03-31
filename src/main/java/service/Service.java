package service;

import entity.Chromosome;
import entity.Population;
import repository.FileRepo;

import java.util.Random;

public class Service {

    private FileRepo repo;
    private Random r;

    public Service(FileRepo repo) {
        this.repo = repo;
        r = new Random();
    }

    private Double fitness(Chromosome c){
        return repo.get(c.getCurrentPosition());
    }

    private void evaluate(Population p){
        for(Chromosome c:p.getChromosomesList()){
            if(fitness(c)<repo.get(p.getBestPosition())){
                p.setBestPosition(c.getCurrentPosition());
            }
        }
    }

    public void updateChromosomeBestPosition(Chromosome c){
        if(fitness(c)<repo.get(c.getBestPosition())){
            c.setBestPosition(c.getCurrentPosition());
        }
    }

    private void updateSpeed(Chromosome c,Double inertiaFactor,Double cognitiveLearningFactor,Double socialLearningFactor,Integer populationBest){
        Double speed = c.getSpeed();
        speed = speed * inertiaFactor + cognitiveLearningFactor * Math.random() * (populationBest-c.getCurrentPosition()) + socialLearningFactor * Math.random() * (c.getBestPosition() - c.getCurrentPosition());
        c.setSpeed(speed);
    }

    private void updatePosition(Chromosome c){
        if(c.getCurrentPosition()+c.getSpeed()<0){
            c.setCurrentPosition(0);
            return;
        }
        if(c.getCurrentPosition()+c.getSpeed()>=repo.getSize()){
            c.setCurrentPosition(repo.getSize()-1);
            return;
        }
        else c.setCurrentPosition((int)(c.getCurrentPosition()+c.getSpeed()));
    }


    public Double solve(Integer numberOfIterations,Integer populationSize,Double inertiaFactor,Double cognitiveLearningFactor,Double socialLearningFactor){
        Population p = new Population();
        for(int i=0;i<populationSize;i++){
            Chromosome c = new Chromosome(r.nextInt(repo.getSize()));
            p.addChromosome(c);
        }
        evaluate(p);
        for(int i=0;i<numberOfIterations;i++){
            for(Chromosome c:p.getChromosomesList()){
                updateSpeed(c,inertiaFactor,cognitiveLearningFactor,socialLearningFactor,p.getBestPosition());
                updatePosition(c);
                updateChromosomeBestPosition(c);
            }
            evaluate(p);
        }
        return repo.get(p.getBestPosition());
    }
}
