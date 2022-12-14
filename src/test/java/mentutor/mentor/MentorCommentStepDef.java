package mentutor.mentor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import mentutor.login.base.SetBaseLogin;
import mentutor.mentee.menteeAPI;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class MentorCommentStepDef {
    @Steps
    SetBaseLogin LoginAPI;
    menteeAPI MenteeAPI;
    @Given("User set forum id to {int} and comment {string}")
    public void mentorSetForumIdToAndCaption(int forum, String comment) {
        LoginAPI.setAddMentorComment(forum,comment);
    }

    @When("User send request post add comment")
    public void userSendRequestPostAddComment() {
        SerenityRest.when().post(mentorAPI.ADD_MENTOR_COMMENT);
    }

    @Given("User set forum id to {string} and comment {string}")
    public void mentorSetForumIdToAndComment(String forum, String comment) {
        LoginAPI.setAddMentorCommentInvalid(forum,comment);
    }

    @Given("User set comment {string}")
    public void mentorSetComment(String comment) {
        LoginAPI.setAddMentorCommentwithoutID(comment);
    }

    @Given("User set forum id to {int} and comment {int}")
    public void mentorSetForumIdToAndComment(int forum, int comment) {
        LoginAPI.setAddMentorCommentfloat(forum,comment);
    }

    @Given("User set forum id to {int} and comment to {float}")
    public void mentorSetForumIdToAndComment(int forum, float comment) {
        LoginAPI.setAddMentorCommentfloat(forum,comment);
    }

    @Given("User set forum id to {int}")
    public void mentorSetForumIdTo(int forum) {
        LoginAPI.setAddMentorCommentWithoutData(forum);
    }
    @Given("Mentee set forum id to {int} and comment {string}")
    public void menteeSetForumIdToAndComment(int forum, String comment) {
        LoginAPI.setAddMentorComment(forum,comment);
    }
    @Given("Mentee set forum id to {string} and comment {string}")
    public void menteeSetForumIdToAndComment(String forum, String comment) {
    }

}
