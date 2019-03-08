package projects.personal.backtracking;

public class GraphColoring {

    private static boolean backTrack(int graph[][], int currentVertex, int colour[], int graphVerticesCount, int numOfColors) {
        if(currentVertex == graphVerticesCount) {
            printSolution(colour,graphVerticesCount);
            return true;
        }

        for(int currentColour = 1; currentColour <= numOfColors; currentColour++) {
            if(isSafe(currentColour, currentVertex, colour, graph, graphVerticesCount)) {
                addColor(colour, currentVertex, currentColour);
                if(backTrack(graph, currentVertex + 1, colour, graphVerticesCount,numOfColors)) {
                    return true;
                }
                removeColor(colour,currentVertex);
            }
        }
        return false;
    }

    private static boolean isSafe(int currentColor, int currentVertex,int colour[], int graph[][], int graphVerticesCount) {
        for(int i = 0; i < graphVerticesCount; ++i) {
            if(graph[currentVertex][i] == 1 && colour[i] == currentColor) {
                return false;
            }
        }
        return true;
    }

    private static void addColor(int colour[], int currentVertex, int currentColor) {
        colour[currentVertex] = currentColor;
    }

    private static void removeColor(int colour[], int currentVertex) {
        colour[currentVertex] = 0;
    }

    private static void printSolution(int color[], int graphVerticesCount) {
        System.out.println("Solution Exists: Following are the assigned colors");
        for (int i = 0; i < graphVerticesCount; i++)
            System.out.print(" " + color[i] + " ");
        System.out.println();
    }

    private static void initColor(int[] color, int V) {
        for(int i = 0; i < V; ++i) {
            color[i] = 0;
        }
    }

    public static void main(String[] args) {
        int graph[][] =
                {{0, 1, 1, 1},
                        {1, 0, 1, 0},
                        {1, 1, 0, 1},
                        {1, 0, 1, 0}};

        int graphVerticesCount = 4; // Number of vertices in a graph
        int numOfColors = 3;
        int[] color = new int[graphVerticesCount];
        initColor(color,graphVerticesCount);

        backTrack(graph,0,color,graphVerticesCount,numOfColors);
    }

}

