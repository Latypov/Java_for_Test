package my.javapr.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Nurulla on 4/25/2016.
 */
public class GithubTests {

  @Test
  public  void testCommits() throws IOException {
    Github github = new RtGithub("35a1fdda8830023f4d2eb7600d83a4ace51663b7");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("Latypov", "Java_for_Test")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }
}
