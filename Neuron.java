public class Neuron {
    int layerlevel;
    int neuronNumber;
    double[] inputsWeight;
    double[] inputsValue;
    double out;

    public void setLayerLevel(int l){
        layerlevel = l;
    }

    public int getLayerlevel(){
        return layerlevel;
    }

    public void setNeuronNumber(int l){
        neuronNumber = l;
    }

    public int getNeuronNumber(){
        return neuronNumber;
    }

    public void setInputWeightDimension(int l){
        inputsWeight = new double[l];
    }

    public int getInputWeightDimension(int inputNumber){ return inputsWeight.length; }

    public void setInputWeight(double w, int inputNumber){ inputsWeight[inputNumber] = w;}

    public double getInputWeight(int inputNumber){return inputsWeight[inputNumber];}
    public double[] getInputWeight(){return inputsWeight;}
    public void setInputsValue(double v, int num){inputsValue[num]=v;}
    public double getInputValue(int num){return inputsValue[num];}




    public void getAxonOutTest (double a){
        if (a>0.5){
        System.out.println("Hello World!");}
        else {
            System.out.println("Пшел нах сучка");
        }
    }

    public double getActivationFunction (double a){
        double b;
        b = 1/(1+(Math.pow(Math.E,-a)));
        return b;
    }

    public double getOut(){
        return out;
    }

    public void calculateNeuronOut(){
        double inputSum = 0;
        for (int i =0; i<inputsWeight.length;i++){
            inputSum = inputSum + inputsWeight[i]*inputsValue[i];
        }
        if (inputSum<=0){out=0;}
        else {out=1;}
    }

    public void initializeNeuron (int inputsMassiveLenght){
        layerlevel = 0;
        neuronNumber = 0;
        inputsWeight = new double[inputsMassiveLenght];
        inputsValue = new double[inputsMassiveLenght];
        out = 0;

    }
    public void initializeZeroLevelNeuron (){
        layerlevel = 0;
        neuronNumber = 0;
        inputsWeight = new double[1];
        inputsWeight[0] = 1;
        inputsValue = new double[1];
        out = 0;

    }
}
