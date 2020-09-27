package uz.crm.system.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import uz.crm.system.entity.catalogs.Category;
import uz.crm.system.exception.BadRequestException;

import java.util.Arrays;


public class CommonUtils {

    //VALIDATE PAGE AND SIZE IN PAGEABLE
    public static void validatePageAndSize(int page, int size) throws BadRequestException {
        if (page < 0)
            throw new BadRequestException("Страница не может быть меньше нуля");
        if (size < 1)
            throw new BadRequestException("Размер не может быть меньше нуля");
        if (size > AppConstants.MAX_SIZE)
            throw new BadRequestException("Количество строк не может быть больше чем " + AppConstants.MAX_SIZE);
    }

    public static Pageable getPageable(int page, int size) throws BadRequestException {
        validatePageAndSize(page, size);
        return PageRequest.of(page, size);
    }

    public static Pageable getPageable(int page, int size, Sort.Direction direction, String... field) throws BadRequestException {
        validatePageAndSize(page, size);
        return PageRequest.of(page, size, direction, field);
    }

    //GENERATE CODE
    public static String GenerateNewCode(String maxCode) {
        String[] letters = {"A", "B", "C", "...", "Z"};

        if (maxCode != null) {
            String first = maxCode.substring(0, 1);
            String second = maxCode.substring(1, 2);
            String multiZeros = "";
            String maxCodeNumber = maxCode.substring(3);
            int numberMaxCode = Integer.parseInt(maxCodeNumber);
            int a = 0;
            if (numberMaxCode == 999999) {
                int secondIndex = Arrays.asList(letters).indexOf(second);
                if (secondIndex == letters.length - 1) {
                    int firstIndex = Arrays.asList(letters).indexOf(first);
                    first = letters[firstIndex + 1];
                    second = letters[0];
                } else {
                    second = letters[secondIndex + 1];
                }
                return first + second + "-000001";
            } else {
                maxCodeNumber = String.valueOf(numberMaxCode + 1);
                a = Integer.parseInt(maxCodeNumber);
                if (a >= 10) {
                    multiZeros = "0000";
                } else {
                    if (a >= 100) {
                        multiZeros = "000";
                    } else {
                        if (a >= 1000) {
                            multiZeros = "00";
                        } else {
                            if (a >= 1000) {
                                multiZeros = "0";
                            } else {
                                multiZeros = "00000";
                            }
                        }
                    }
                }
                return first + second + "-" + multiZeros + maxCodeNumber;
            }
        } else {
            return "AA-000001";
        }

    }

    // GET CATEGORIES TILL THE LAST PARENT
    public String getCategoryToFinish(Category category) {
        StringBuilder categoryName = new StringBuilder(category.getName());
        boolean finish = true;
        while (finish) {
            if (category.getParent() != null) {
                categoryName.insert(0, category.getParent().getName() + ",");
            } else {
                finish = false;
            }
        }
        return categoryName.toString();
    }
}
