import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.max;
import static java.util.Collections.min;

public class Uttarakhand {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ch.srivastava\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://results.eci.gov.in/ResultAcGenMar2022/ConstituencywiseS0510.htm?ac=10");
        driver.manage().window().maximize();

        String stateName = "Uttarakhand";
        Select state = new Select(driver.findElement(By.xpath("//select[@id='ddlState']")));
        state.selectByValue("S28");
        int Total_Constituency = driver.findElements(By.xpath("//*[@id='ddlAC']/option")).size();
        Select Constituency = new Select(driver.findElement(By.xpath("//select[@id='ddlAC']")));
        List<String> ConstituencyName = new ArrayList<String>();
        List<String> CandidateName = new ArrayList<String>();
        List<Double> candidateWithMaxVotePercentage = new ArrayList<Double>();
        List<Integer> runnerUpVote = new ArrayList<Integer>();
        List<Double> runnerUpVotePercentage = new ArrayList<Double>();
        List<Integer> candidatesWithMaxVote = new ArrayList<Integer>();
        List<Integer> candidate_with_less_than_Nota = new ArrayList<Integer>();

        for(int a = 1;a<=Total_Constituency-1;a++) {

            Constituency.selectByIndex(a);
            List<String> candidateName = new ArrayList<String>();
            List<Integer> candidateVote = new ArrayList<Integer>();
            List<Integer> runnerupVote = new ArrayList<Integer>();
            List<Double> candidateVotePercentage = new ArrayList<Double>();

            String constName = driver.findElement(By.xpath("//*[@id='ddlAC']/option[" + (a + 1) + "]")).getText();
            ConstituencyName.add(constName);
            int totalRows = driver.findElements(By.xpath("//*[@id='div1']/table[1]/tbody/tr")).size();
            int NotaVote = Integer.parseInt(driver.findElement(By.xpath("//*[@id='div1']/table[1]/tbody/tr[" + (totalRows - 1) + "]/td[6]")).getText());
            int count_Less_than_Nota = 0;

            for (int i = 4; i <= totalRows - 1; i++) {
                candidateName.add(driver.findElement(By.xpath("//*[@id='div1']/table[1]/tbody/tr[" + i + "]/td[2]")).getText());
                int No_Of_Votes = Integer.parseInt(driver.findElement(By.xpath("//*[@id='div1']/table[1]/tbody/tr[" + i + "]/td[6]")).getText());
                if (No_Of_Votes < NotaVote) {
                    ++count_Less_than_Nota;
                }
                candidateVote.add(No_Of_Votes);
                runnerupVote.add(No_Of_Votes);
                candidateVotePercentage.add(Double.parseDouble(driver.findElement(By.xpath("//*[@id='div1']/table[1]/tbody/tr[" + i + "]/td[7]")).getText()));
            }
            candidate_with_less_than_Nota.add(count_Less_than_Nota);
            int idx = candidateVote.indexOf(max(candidateVote));
            Collections.sort(runnerupVote);
            int secondHighest = runnerupVote.get(runnerupVote.size() - 2);
            int runnerUpIdx = candidateVote.indexOf(secondHighest);
            runnerUpVote.add(candidateVote.get(runnerUpIdx));
            runnerUpVotePercentage.add(candidateVotePercentage.get(runnerUpIdx));
            CandidateName.add(candidateName.get(idx));
            candidatesWithMaxVote.add(candidateVote.get(idx));
            candidateWithMaxVotePercentage.add(candidateVotePercentage.get(idx));
            Constituency = new Select(driver.findElement(By.xpath("//select[@id='ddlAC']")));
        }
        System.out.println("Uttarakhand");
        System.out.println("Total number of constituencies are : " + (Total_Constituency-1));
        //1.Candidate which has got the maximum vote in each state with their constituency name.
        Candidate_won_with_max_Vote(ConstituencyName, CandidateName, candidatesWithMaxVote);
        //2.Candidate which has got the maximum percentage of vote in each state with their constituency name.(percentage)
        Candidate_won_with_max_Vote_Percentage(ConstituencyName,CandidateName, candidateWithMaxVotePercentage);
        //3.Candidate who won with maximum vote difference.
        Candidate_won_with_max_Vote_difference(ConstituencyName, CandidateName, candidatesWithMaxVote,runnerUpVote);
        //4.Candidate who won with maximum vote percentage difference.
        Candidate_won_with_max_Vote_Percentage_difference(ConstituencyName, CandidateName, candidateWithMaxVotePercentage,runnerUpVotePercentage);
        //5.candidate who won with minimum vote.
        Candidate_won_with_min_Vote_difference(ConstituencyName, CandidateName, candidatesWithMaxVote,runnerUpVote);
        // 6.Candidate who won with minimum vote percentage.
        Candidate_won_with_min_Vote_Percentage_difference(ConstituencyName,CandidateName, candidateWithMaxVotePercentage,runnerUpVotePercentage);
        // 7.Total count of candidate who have got less vote than nota.
        System.out.println("Count less than nota  : " + SUM(candidate_with_less_than_Nota));
        //8. Total count of candidates who have got greater than 50% vote.
        int total_count_Greater_than_50 = count_of_candidate_greater_than_50_percent(candidateWithMaxVotePercentage);
        System.out.println("candidate greater than 50% : " + total_count_Greater_than_50);
        // 9.Name of candidate who have got minimum vote in each state.
        Candidate_won_with_min_Vote(ConstituencyName, CandidateName, candidatesWithMaxVote);
        //Candidate_won_with_min_Vote_Percentage(stateName, ConstituencyName, CandidateName, candidateWithMaxVotePercentage);

    }
    public static int SUM(List<Integer> list){
        int sum = 0;
        for(int i =0;i<list.size();i++){
            sum+=list.get(i);
        }
        return sum;
    }

    public static void  Candidate_won_with_max_Vote(List<String> placename, List<String> winner, List<Integer> Votes) {
        int idx = Votes.indexOf(max(Votes));
        System.out.println("Candidate won with Maximum vote is from  : " +  placename.get(idx) + "  " + winner.get(idx) + "  " + Votes.get(idx));



    }
    public static void Candidate_won_with_min_Vote(List<String> placename, List<String> winner, List<Integer> Votes) {
        int idx = Votes.indexOf(min(Votes));
        System.out.println("Candidate won with minimum vote is from : " + placename.get(idx) + "  " + winner.get(idx) + "  " + Votes.get(idx));

    }

    public static void Candidate_won_with_max_Vote_Percentage(List<String> placename, List<String> winner, List<Double> VotesPercentage) {
        int idx = VotesPercentage.indexOf(max(VotesPercentage));
        System.out.println("Candidate won with maximum vote percentage is from :" +placename.get(idx) + " " +  winner.get(idx) + "  " + VotesPercentage.get(idx) + "%");

    }

    public static int count_of_candidate_greater_than_50_percent(List<Double> VotesPercentage) {
        int count = 0;
        for (int i = 0; i < VotesPercentage.size(); i++) {
            if (VotesPercentage.get(i) >= 50.00) {
                ++count;
            }
        }

        return count;
    }

    public static void Candidate_won_with_max_Vote_difference(List<String> placename, List<String> winner, List<Integer> Votes, List<Integer> runnerUpVotes) {
        int idx;
        List<Integer> differenceList = new ArrayList<Integer>();
        for (int i = 0; i < Votes.size() && i < runnerUpVotes.size(); i++) {
            differenceList.add(Votes.get(i) - runnerUpVotes.get(i));
        }
        idx = differenceList.indexOf(max(differenceList));
        System.out.println("Candidate won with maximum vote difference is : " + winner.get(idx)+ " from " + placename.get(idx)+"  "+ differenceList.get(idx));


    }
    public static void Candidate_won_with_min_Vote_difference(List<String> placename, List<String>winner, List<Integer> Votes, List<Integer> runnerUpVotes) {
        int idx;
        List<Integer> differenceList = new ArrayList<Integer>();
        for (int i = 0; i < Votes.size() && i < runnerUpVotes.size(); i++) {
            differenceList.add(Votes.get(i) - runnerUpVotes.get(i));
        }
        idx = differenceList.indexOf(min(differenceList));
        System.out.println("Candidate won with minimum vote difference is from : " +  placename.get(idx)+"  "+ winner.get(idx)+ "   " + differenceList.get(idx));

    }

    public static void Candidate_won_with_max_Vote_Percentage_difference( List<String> placename, List<String> winner, List<Double> VotesPercentage,  List<Double> runnerUpVotesPercentage) {
        int idx;
        List<Double> differenceList = new ArrayList<Double>();
        for (int i = 0; i < VotesPercentage.size() && i < runnerUpVotesPercentage.size(); i++) {
            differenceList.add(VotesPercentage.get(i) - runnerUpVotesPercentage.get(i));
        }
        idx = differenceList.indexOf(max(differenceList));
        System.out.println("Candidate won with maximum vote difference percentage is from : " + placename.get(idx)+"  "+ winner.get(idx)+ differenceList.get(idx)+"% ");
    }

    public static void Candidate_won_with_min_Vote_Percentage_difference(List<String> placename , List<String> winner, List<Double> VotesPercentage, List<Double> runnerUpVotesPercentage) {
        int idx;
        List<Double> differenceList = new ArrayList<Double>();

        for (int i = 0; i < VotesPercentage.size() && i < runnerUpVotesPercentage.size(); i++) {

            differenceList.add((VotesPercentage.get(i) - runnerUpVotesPercentage.get(i)));
        }
        idx = differenceList.indexOf(min(differenceList));
        System.out.println("Candidate won with minimum vote difference percentage is from : " + placename.get(idx)+ "  "+ winner.get(idx) + differenceList.get(idx)+"% ");


    }}


