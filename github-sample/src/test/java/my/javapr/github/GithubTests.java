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
    Github github = new RtGithub("b89664c0a988b6c40ed35f8f0b2d1174710006f4");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("Latypov", "Java_for_Test")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
      System.out.println(new RepoCommit.Smart(commit).message());
  }

  }
}
