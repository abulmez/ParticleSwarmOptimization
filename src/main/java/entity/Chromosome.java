package entity;

public class Chromosome {
    private Integer currentPosition,bestPosition;
    private Double speed;

    public Chromosome(Integer currentPosition){
        this.currentPosition = currentPosition;
        bestPosition = currentPosition;
        speed = 0.0;
    }

    public Integer getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Integer currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Integer getBestPosition() {
        return bestPosition;
    }

    public void setBestPosition(Integer bestPosition) {
        this.bestPosition = bestPosition;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }
}
