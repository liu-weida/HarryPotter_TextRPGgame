package Game;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class LevelTest {
    @Mock
    Game game;
    @InjectMocks
    Level level;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAdventure1st(){
        Level.adventure1st();
    }

    @Test
    public void testBoss1st(){
        Level.boss1st();
    }

    @Test
    public void testAdventure2nd(){
        Level.adventure2nd();
    }

    @Test
    public void testBoss2nd(){
        Level.boss2nd();
    }

    @Test
    public void testAdventure3rd(){
        Level.adventure3rd();
    }

    @Test
    public void testBoss3rd(){
        Level.boss3rd();
    }

    @Test
    public void testAdventure4th(){
        Level.adventure4th();
    }

    @Test
    public void testBoss4th(){
        Level.boss4th();
    }

    @Test
    public void testAdventure5th(){
        Level.adventure5th();
    }

    @Test
    public void testBoss5th(){
        Level.boss5th();
    }

    @Test
    public void testAdventure6th(){
        Level.adventure6th();
    }

    @Test
    public void testBoss6th(){
        Level.boss6th();
    }

    @Test
    public void testAdventure7th(){
        Level.adventure7th();
    }

    @Test
    public void testBoss7th(){
        Level.boss7th();
    }

    @Test
    public void testGraduationCeremony(){
        Level.graduationCeremony();
    }
}
