package kbtg.tech.backendexam.entity;

public class SalaryAdjustPercentage {
    private float percent;

    public SalaryAdjustPercentage(float percent) {
        this.percent = percent;
    }

    public SalaryAdjustPercentage() {
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }
}
