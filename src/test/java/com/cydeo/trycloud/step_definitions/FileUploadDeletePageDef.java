package com.cydeo.trycloud.step_definitions;

import com.cydeo.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FileUploadDeletePageDef {

    com.cydeo.trycloud.pages.FileUploadDeletePage page = new com.cydeo.trycloud.pages.FileUploadDeletePage();

    @When("the user upload {string}")
    public void the_user_upload(String fileName) {
        page.uploadFile(fileName);
    }

    @When("the user create new folder {string}")
    public void the_user_create_new_folder_TestFolder(String fileName) {
        page.createFolder(fileName);
    }


    @Then("the user should see folder on page {string}")
    public void the_user_should_see_TestFolder_on_page(String createdFolder) {
        String expectedFolder=createdFolder;
        String actualFolder= page.isUploadedOrCreated(createdFolder);

        Assert.assertEquals(expectedFolder, actualFolder);

    }

    @Then("the user should see {string} on page")
    public void the_user_should_see_on_page(String addedFile) {

            String expectedUploadedFile=addedFile;
            String actualUploadedFile=page.isUploadedOrCreated(addedFile);

            System.out.println("expectedUploadedFile = " + expectedUploadedFile);
            System.out.println("actualUploadedFile = " + actualUploadedFile);

            Assert.assertEquals(expectedUploadedFile, actualUploadedFile);
            page.deleteItem(addedFile);

    }

    @When("the user move the {string} to {string}")
    public void the_user_move_the_to(String item, String folder) {
        page.moveTo(item, folder);
    }

    @Then("the user should see moved {string} in {string}")
    public void the_user_should_see_moved_in(String item, String folder) {
        String actualResult=page.isInFolder(item, folder);
        String expectedResult=item;

        Assert.assertEquals(expectedResult, actualResult);
        page.moveToBack(item);
    }

    @Then("the user should see copied {string} in {string} and FileList")
    public void the_user_should_see_copied_in(String item, String folder) {
        if(page.isInMainFileList(item)) {

            String actualResult=page.isInFolder(item, folder);
            String expectedResult=item;

            Assert.assertEquals(expectedResult, actualResult);
            page.deleteItem(item);

        }
    }

    @When("the user copy the {string} to {string}")
    public void the_user_copy_the_to(String item, String folder) {
        page.copyTo(item, folder);
    }

    @When("the user delete any selected {string}")
    public void the_user_delete_any_selected(String item) {
        page.fileActionMenu(item).click();
        BrowserUtils.sleep(3);
        page.deleteFile.click();
        BrowserUtils.sleep(3);
    }

    @Then("the user should see {string} in deleted files")
    public void the_user_should_see_in_deleted_files(String item) {
        String expectedResult=item;
        String actualResult=page.isInDeletedFile(item);

        Assert.assertEquals(expectedResult, actualResult);
        page.restoreFile(item);

    }

    @Then("the user should see total number of files and folders")
    public void the_user_should_see_total_number_of_files_and_folders() {

        int expectedFileNumber=page.getDisplayedFileNumber();
        int actualFileNumber=page.countFile();

        Assert.assertEquals(expectedFileNumber, actualFileNumber);

        int expectedFolderNumber=page.getDisplayedFolderNumber();
        int actualFolderNumber=page.countFolder();

    }
}
