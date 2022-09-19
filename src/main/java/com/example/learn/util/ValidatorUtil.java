//package com.example.learn.util;
//
//import com.example.learn.exception.BizException;
//import net.sf.oval.ConstraintViolation;
//import net.sf.oval.Validator;
//import org.apache.commons.lang3.StringUtils;
//
//
//import java.util.List;
//
//
//public class ValidatorUtil {
//    private static final Validator VALIDATOR = ((HibernateValidatorConfiguration) Validation.byProvider(HibernateValidator.class).configure()).failFast(true).buildValidatorFactory().getValidator();
//    private static net.sf.oval.Validator validatorOval = new net.sf.oval.Validator();
//
//    private ValidatorUtil() {
//    }
//
//    public static <T> void validate(T... validateModel) {
//        int var2 = validateModel.length;
//        byte var3 = 0;
//        if (var3 < var2) {
//            T valid = validateModel[var3];
//            Set<ConstraintViolation<T>> violations = VALIDATOR.validate(valid, new Class[0]);
//            if (null != violations && !violations.isEmpty()) {
//                throw new BizException(((ConstraintViolation) violations.iterator().next()).getMessage());
//            }
//        }
//    }
//
//    public static void validateOval(Object object) {
//        List<net.sf.oval.ConstraintViolation> list = validatorOval.validate(object);
//        if (null != list && !list.isEmpty()) {
//            throw new BizException(((net.sf.oval.ConstraintViolation) list.get(0)).getMessage());
//        }
//    }
//
//    public static void validateStringBlank(String... validateModel) {
//        String[] var1 = validateModel;
//        int var2 = validateModel.length;
//
//        for (int var3 = 0; var3 < var2; ++var3) {
//            String valid = var1[var3];
//            if (StringUtils.isBlank(valid)) {
//                throw new BizException(valid + " is blank");
//            }
//        }
//
//    }
//
//    public static void checkInsertOne(int insertNum) {
//        if (insertNum < 1) {
//            throw new BizException("DATA_INSERT_ERROR");
//        }
//    }
//
//    public static void checkUpdateOne(int updateNum) {
//        if (updateNum < 1) {
//            throw new BizException("DATA_UPDATE_ERROR");
//        }
//    }
//
//    public static void checkSaveBatch(boolean insertFlag) {
//        if (!insertFlag) {
//            throw new BizException("DATA_INSERT_ERROR");
//        }
//    }
//}