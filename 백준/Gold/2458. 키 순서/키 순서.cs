using System;
using System.Collections.Generic;

class Program {
    public static void Main(string[] args) {
        string[] input = Console.ReadLine().Split();
        int N = int.Parse(input[0]);
        int M = int.Parse(input[1]);

        bool[,] graph = new bool[N + 1, N + 1];

        for (int i = 0; i < M; i++) {
            input = Console.ReadLine().Split();
            int a = int.Parse(input[0]);
            int b = int.Parse(input[1]);
            graph[a, b] = true;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i, k] && graph[k, j]) {
                        graph[i, j] = true;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            int tmp = 0;
            for (int j = 1; j <= N; j++) {
                if (graph[i, j] || graph[j, i]) {
                    tmp++;
                }
            }
            if (tmp == N - 1) {
                count++;
            }
        }

        Console.WriteLine(count);
    }
}
