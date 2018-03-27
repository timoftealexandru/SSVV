import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import model.Entry;
import model.Member;
import repository.MemberRepository;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    /**
     * test for adding member
     */
    public void testAddMember() {
        Member member = new Member("Nicu", "1", 100, 150);
        MemberRepository repo = new MemberRepository();
        repo.addMember(member);
        List<Member> members = repo.getAllMembers();
        Member last = members.get(members.size() -1);
        assert (member==last);
    }

    /**
     * test for adding entry
     */
    public void testAddEntry() {
        Entry entry = new Entry("Entry1",  100, 1);
        MemberRepository repo = new MemberRepository();
        repo.addEntry(entry);
        List<Entry> entries = repo.getAllEntries();
        Entry last = entries.get(0);
        assert (entry == last);
    }
}
