package features.readRecipes;

import features.readFile.ReadFileFeature;
import features.readRecipes.helpers.ResultHelper;
import features.readRecipes.models.Recipes;
import features.readRecipes.services.ParseRecipeListService;
import helpers.StringHelper;
import models.OperationResultMessage;
import models.OperationResultStatus;

public class ReadRecipesFeature {
    private final ReadFileFeature readFileFeature;
    private final ParseRecipeListService parseRecipeListService;
    public ReadRecipesFeature(ReadFileFeature readFileFeature,ParseRecipeListService parseRecipeListService){
        this.readFileFeature = readFileFeature;
        this.parseRecipeListService = parseRecipeListService;
    }
    public OperationResultMessage<Recipes> getRecipes(){
        OperationResultMessage<String> readRecipeListMessage = ReadRecipeList();
        if (IsReadingRecipeUnsuccessful(readRecipeListMessage)){
            return ResultHelper.errorResult(readRecipeListMessage.getMessage());
        }
        return ParseRecipeList(readRecipeListMessage.getResult());
    }
    private boolean IsReadingRecipeUnsuccessful(OperationResultMessage<String> readRecipeListMessage){
        return readRecipeListMessage.getStatus() != OperationResultStatus.SUCCESS;
    }
    private OperationResultMessage<Recipes> ParseRecipeList(String input){
        return parseRecipeListService.Parse(input);
    }
    private OperationResultMessage<String> ReadRecipeList(){
        return readFileFeature.readToString(StringHelper.RECIPES_FILE_PATH);
    }

}
