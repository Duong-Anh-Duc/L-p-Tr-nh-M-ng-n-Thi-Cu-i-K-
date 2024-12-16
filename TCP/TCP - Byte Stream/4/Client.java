package src;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Client {
    public static void main(String[] args) throws Exception, ClassNotFoundException {
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        os.write("B21DCCN001;XGIm2Fc7".getBytes());
        os.flush();
        byte[] data = new byte[1024];
        int read = is.read(data);
        String arr[] = new String(data, 0, read).split(",");
        ArrayList<Integer> a = new ArrayList<>();
        for (String x : arr) {
            System.out.print(x + ",");
            a.add(Integer.parseInt(x));
        }
        System.out.println("");
        int[] parent = new int[100001];
        int dp[] = new int[100001];
        Arrays.fill(parent, -1);
        Arrays.fill(dp, 1);
        int max_length = 1;
        int index = 0;
        for (int i = 1; i < a.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (a.get(i) > a.get(j) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > max_length) {
                max_length = dp[i];
                index = i;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (index != -1) {
            result.add(a.get(index));
            index = parent[index];
        }
        Collections.reverse(result);
        String res = "";
        for (int i = 0; i < max_length; i++) {
            res += result.get(i) + (i != max_length - 1 ? "," : ";" + max_length);
        }
        os.write(res.getBytes());
        System.out.println(res);
        socket.close();
    }
}