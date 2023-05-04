# Structure

## Board Package

### Board Class
- Relationship:
    public class Board

- Attributes: 
    private Sector tab[][];

- Constructor: 
    public Board()

- Getters and Setters
    public Sector getSector(int x, int y) 
    public Sector getSector(Player p) 
    public Virus getEnemy(Player p)

- Methods:
	public void virusTurn(Player p, Random generator)

### Door Class
- Relationship:
    public class Door 

- Attributes: 
    private int u
    private int d
    private int l
    private int r

- Constructor: 
    public Door(int u, int d, int l, int r)

- Getters and Setters
    public int getR() 
    public int getU() 
    public int getD() 
    public int getL() 

- Methods
    public void printDoors() 

### Sector Class
- Relationship:
    public class Sector 

- Attributes:
    private Door door
    private boolean known
    private boolean infection
    private ArrayList<Virus> enemies
    private int players;

- Constructor:
    public Sector(int u, int d, int l, int r)

- Getters and Setters
    public int getPlayers() 
    public void setPlayers(int np) 
    public ArrayList<Virus> getEnemies()
    public void setInfection() 

- Methods
    public int hasDoor(char dir) 
    public boolean isKnown() 
    public void visitSector() 
    public void printDoors() 
    public boolean hasInfection() 
    public void printSector(int i, int j) 
    public void removePlayers(int P) 
    public void addPlayers(int P) 
    public void generateEnemies(Random rand)
    public void printEnemies() 
    public int haveEnemies() 

### SectorOcult Class
- Relationship:
    public class SectorOcult extends Sector

- Attributes:

- Constructor:
    public SectorOcult(int u, int d, int l, int r) 

- Getters and Setters

- Methods

### SectorPrivate Class
- Relationship:
    public class SectorPrivate extends Sector

- Attributes:

- Constructor:
    public SectorPrivate(int u, int d, int l, int r) 

- Getters and Setters

- Methods

### PrintGame Class
- Relationship:
    public class PrintGame

- Attributes:

- Constructor:

- Getters and Setters

- Methods
    public void printBoard(Player main, Player support, Board tab) 
    public void prinSet(Sector set, int lin, Player main, int P) 
    public void prinSet(Sector set, int lin, Player main, Player support) 
    public void showPossibleActions(Player p, Sector set) 
    public void printHeader(int turn) 
    public void printTable(Board tabb, Player[] p, int turno) 
    public void printSector(Player p, Sector set)
    public void printWinMessage()
    public void availableDirections(Sector set)

## Entities package

### Coordinates Class
- Relationship:
    public class Coordinates

- Attributes:
    private int x
    private int y

- Constructor:
    public Coordinates(int x, int y) 

- Getters and Setters
    public int getX() 
    public int getY() 
    public void setX(int x) 
    public void setY(int y) 
    public void setCoordinates(int x, int y) 

- Methods

### Entity Class
- Relationship:
    public abstract class Entity 

- Attributes:
    protected int attackPower
    protected int defensePower

- Constructor:
    public Entity() 
    public Entity(int attackPower, int defensePower) 

- Getters and Setters
    public int getAttackPower() 
    public int getDefensePower() 
    public void setAttackPower(int attackPower) 
    public void setDefensePower(int defensePower) 

- Methods
    public boolean attack(Entity entity) 

### Player Class
- Relationship:
public class Player extends Entity 

- Attributes:
    private Coordinates position

- Constructor:
    public Player() 
    public Player(int attackPower, int defensePower, int x, int y)

- Getters and Setters
    public Coordinates getPosition() 
    public void setPosition(int x, int y) 

- Methods
    public void incrementDefense(int increment)
    public void search(Sector setor) 
    public int move(Board T, char dir, int P) 
    public int playerAction(Board tab, char input, Player []p, Scanner reader)
    public boolean isSupport() 
    public boolean isAlive()
    public boolean availabeOptions(Board tab)
    public boolean isGameWon(Board tab)

### SupPlayer Class
- Relationship:
    public class SupPlayer extends Player 
- Attributes:

- Constructor:
    public SupPlayer()

- Getters and Setters

- Methods
    public void heal(Player player)

### SupPlayer Class
- Relationship:
    public class Virus extends Entity 
- Attributes:

- Constructor:
    public Virus() 

- Getters and Setters

- Methods
    public Virus(Random generator)

## Main
### Main Class
- Relationship:
    public class Main

- Attributes:

- Constructor:

- Getters and Setters

- Methods
public static void flush_terminal()
public static void main(String[] args) throws InterruptedException