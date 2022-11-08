package AllStarBaseballHW;

public class AllStarBaseballHW {
    public static void main(String[] args) {
        addPlayers();
        playGame();
    }

    private static void playGame() {
        int batter = 1;
        int inning = 1;
        int outs = 0;
        int bases = 0;
        int hits = 0;
        int totalHits = 0;
        int totalHR = 0;
        int runs = 0;
        Double randNum = 0.0;
        while(inning <= 4){
            System.out.printf("\n----------- Inning: %s Game Score: %s Runs", inning, runs);
            while(outs < 3){
                randNum = getRandNum();
                int hrRuns = 0;
                if(randNum <= head.player.getHr()){
                    runs += 1 + bases;
                    hrRuns = 1 + bases;
                    totalHR++;
                    System.out.printf("\nBatter %s: %s -> BA: %s Random Number: %.3f %n HOME RUN: %s Run(s) Scored", batter, head.player.getName(), head.player.getbAve(), randNum, hrRuns);
                } else if (randNum <= head.player.getbAve()) {
                    hits++;
                    totalHits++;
                    bases++;
                    System.out.printf("\nBatter %s: %s -> BA: %s Random Number: %.3f %n Hit: %s", batter, head.player.getName(), head.player.getbAve(), randNum, hits);
                    if(bases >= 3){
                        runs++;
                        System.out.printf(" Runs Scored: %s", runs);
                    }
                }else {
                    outs++;
                    System.out.printf("\nBatter %s: %s -> BA: %s Random Number: %.3f %n Outs: %s", batter, head.player.getName(), head.player.getbAve(), randNum, outs);
                }
                batter++;
                tail.next = head;
                head.previous = tail;
                tail = head;
                head = head.next;
                tail.next = null;
            }
            inning++;
            System.out.printf("\n-------------Inning Totals: %s Runs %s Hits", runs, hits);
            outs = 0;
            batter = 1;
            hits = 0;
            bases = 0;
        }
        System.out.printf("\n Game Over! # of Hits: %S # of Home Runs: %s Runs: %s", totalHits, totalHR, runs);
    }

    private static Double getRandNum() {
        return Math.random();
    }

    private static void addPlayers() {
        Player first = new Player("Ted Williams", .344, .0687);
        Player second = new Player("Rogers Hornsby", .359, .0375);
        Player third = new Player("Mark McGwire", .265, .095);
        Player fourth = new Player("Babe Ruth", .340, .085);
        addNode(first);
        addNode(second);
        addNode(third);
        addNode(fourth);
    }

    static class Node{
        Player player;
        Node next;
        Node previous;
        public Node(Player player){
            this.player = player;
            next = null;
            previous = null;
        }
    }
    static Node head;
    static Node tail = null;
    public static void addNode(Player player) {
        Node newNode = new Node(player);
        if (head == null) {
            //It's the first node
            head = newNode;
            tail = newNode;
            head.previous = null;
            tail.next = null;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            tail.next = null;
        }
    }
    static class Player{
        String name;
        Double bAve;
        Double hr;

        public Player(String name, Double bAve, Double hr) {
            this.name = name;
            this.bAve = bAve;
            this.hr = hr;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getbAve() {
            return bAve;
        }

        public void setbAve(Double bAve) {
            this.bAve = bAve;
        }

        public Double getHr() {
            return hr;
        }

        public void setHr(Double hr) {
            this.hr = hr;
        }
    }
}