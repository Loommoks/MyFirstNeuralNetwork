public class Network {
    Neuron[][] neuronNet;

    public static Neuron[][] initializeNetwork (Neuron[][] a,int[] b){
        //Neuron[][] network = new Neuron[l][ninl];
        for (int il =0; il<a.length; il++){
            a[il] = new Neuron[b[il]];
            System.out.println();

            for (int jninl=0; jninl<b[il];jninl++){
                a[il][jninl] = new Neuron();
                a[il][jninl].setNeuronNumber(jninl);
                a[il][jninl].setLayerLevel(il);
                System.out.print(a[il][jninl].getLayerlevel() +"" +a[il][jninl].getNeuronNumber() +"  ");
                if(il>0) {
                    a[il][jninl].setInputWeightDimension(a[il-1].length);
                    for(int ik=0;ik<a[il-1].length;ik++){
                        a[il][jninl].setInputWeight(Math.random(),ik);
                    }

                    double[] c = a[il][jninl].getInputWeight();
                    for (int y=0; y<c.length;y++){System.out.print(c[y]+"  ");}
                }
            }
            System.out.println();
        }
        return a;
    }

    public void initializeTestXORNetwork (int levels, int level0qn, int level1qn, int level2qn){
        neuronNet = new Neuron[levels][];
        int[] l = new int[3];
        l[0]=level0qn;
        l[1]=level1qn;
        l[2]=level2qn;

        for (int il =0; il<neuronNet.length; il++){
            neuronNet[il] = new Neuron[l[il]];
            //System.out.println();

            for (int jninl=0; jninl<l[il];jninl++){
                neuronNet[il][jninl] = new Neuron();
                if (il>0) {
                    neuronNet[il][jninl].initializeNeuron(neuronNet[il - 1].length);
                }
                else {
                    neuronNet[il][jninl].initializeZeroLevelNeuron();
                }
                neuronNet[il][jninl].setNeuronNumber(jninl);
                neuronNet[il][jninl].setLayerLevel(il);
                //System.out.print(neuronNet[il][jninl].getLayerlevel() +"" +neuronNet[il][jninl].getNeuronNumber() +"  ");

            }
            //System.out.println();
        }
        neuronNet[1][0].setInputWeight(1,0);
        neuronNet[1][0].setInputWeight(-1,1);
        neuronNet[1][1].setInputWeight(-1,0);
        neuronNet[1][1].setInputWeight(1,1);
        neuronNet[2][0].setInputWeight(1,0);
        neuronNet[2][0].setInputWeight(1,1);
    }

    public void showNetworkData(){
        System.out.println("Входные данные:["+neuronNet[0][0].getInputValue(0)+"]["+neuronNet[0][1].getInputValue(0)+"]");
        for (int il =0; il<neuronNet.length; il++){

            for (int jninl=0; jninl<neuronNet[il].length;jninl++){
                System.out.print("Нейрон[" +neuronNet[il][jninl].getLayerlevel() +"][" +neuronNet[il][jninl].getNeuronNumber() +"]  ");
                System.out.print("Выход:" +neuronNet[il][jninl].getOut()+"  ");
                double[] wMassive= neuronNet[il][jninl].getInputWeight();
                for (int k=0;k<wMassive.length;k++){
                    System.out.print("Вес["+k+"]: " +wMassive[k]+"  ");
                }
                System.out.println("");
            }
        }
    }


    public double startNetworking(double in[]){
        //По логике даем сигнал на входные нейроны
        //Далее в цикле проходим по всем нейронам каждого слоя и они передают значения на выход
        System.out.println("Входные данные:["+in[0]+"]["+in[1]+"]");
        for (int i=0; i<neuronNet.length;i++){
            if (i==0) {
                for (int j = 0; j < neuronNet[i].length; j++) {
                    neuronNet[i][j].setInputsValue(in[j],0);
                    neuronNet[i][j].calculateNeuronOut();
                    transferSingnal(i,j);
                    System.out.print("Считаю выход нейрона " +i +j +" ");
                    System.out.println("Ок, выход:" +neuronNet[i][j].getOut());

                }
            }
            else {
                for (int j = 0; j < neuronNet[i].length; j++) {
                    neuronNet[i][j].calculateNeuronOut();
                    transferSingnal(i,j);
                    System.out.print("Считаю выход нейрона " +i +j +" ");
                    System.out.println("Ок, выход:" +neuronNet[i][j].getOut());
                }
            }
        }

        return 0;

    }

    public void transferSingnal(int x, int y){
        if (x>=neuronNet.length){System.out.print("Network layer exceeded");}
        else {
            if (x == (neuronNet.length-1)){}
            else {
                for (int i = 0; i < neuronNet[x+1].length; i++) {
                    neuronNet[x+1][i].setInputsValue(neuronNet[x][y].getOut(),y);
                }
            }
        }

    }

    /*public static double[] getRandomWeight (Neuron[][] a,int layer, int number){
        if (layer==0) {
            System.out.println("Пока не меняем вес для нулевого слоя");
            return null;
        }
        else {
            int c = a[(layer-1)].length;
            double[] d = new double[c];
            for (int k = 0; k < a[(layer-1)].length; k++) {
                d[k] = Math.random();
                a[k][number].setInputWeight(d);
            }
            return d;
        }
    }*/

}
