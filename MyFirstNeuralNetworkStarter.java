import java.util.ArrayList;

public class MyFirstNeuralNetworkStarter {
    public static void main (String[] args){

        //Создаем массив нейронов, указываем только количество слоев
        /*Neuron[][] testNet = new Neuron[3][];
        //Создаем массив с информациец о количестве нейронов на каждом слое
        int[] lenght = new int[3];
        lenght[0]=2;
        lenght[1]=2;
        lenght[2]=1;*/

        Network Net = new Network();
        Net.initializeTestXORNetwork(3,2,2,1);
        //Net.showNetworkData();
        double[] input= {0,0};
        Net.startNetworking(input);
        input[0] = 0; input[1]=1;
        Net.startNetworking(input);
        input[0] = 1; input[1]=0;
        Net.startNetworking(input);
        input[0] = 1; input[1]=1;
        Net.startNetworking(input);
        Net.showNetworkData();



        //Инициализируем нейросеть с заданным количеством слоев и нейронов в слое
        //testNet = Network.initializeNetwork(testNet,lenght);
    }



}
