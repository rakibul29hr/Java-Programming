class CircleRadInContructor2 {
    private double radius;
    public CircleRadInContructor2() {
    }
    public void setRadius(double rad) {
        this.radius = rad;
    }
    public double getRadius() {
        return this.radius;
    }
    public double computeArea() {
        return (radius * radius * Math.PI);
    }
}