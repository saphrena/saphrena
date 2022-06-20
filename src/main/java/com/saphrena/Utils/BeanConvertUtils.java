package com.saphrena.Utils;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author 热河
 * @created 2022/6/16 22:25
 * @project saphrena
 * @Description 转换对象工具
 */
public class BeanConvertUtils extends BeanUtils {
    /*
     -------------po vo 转换-------------
           // 使用前
      public Vo findById(Integer id) {
      Vo vo = new Vo();
      Po po = dao.findById(id);
      copyProperties(po, vo);
      return vo;
     }

          // 使用后
      public Vo findById(Integer id) {
         return BeanConvertUtils.converTo(dao.findById(id), Vo::new);
     }

    */

    /*
    -----------list拷贝------------
    //使用前
    public List<Vo> findAll() {
        List<Vo> vos = new ArrayList();
        List<Po> pos = dao.findAll();
        for (Po po : Pos) {
            Vo vo = new Vo();
            BeanUtis.copyProperties(po, vo);
            vos.add(vo);
        }
        return vos;
    }

    // 使用后
    public List<Vo> findAll() {
        return BeanConvertUtils.converToList(dao.findAll(), Vo::new)
    }
    */

    public static <S, T> T convertTo(S source, Supplier<T> targetSupplier) throws InvocationTargetException, IllegalAccessException {
        return convertTo(source, targetSupplier, null);
    }

    /**
     * 转换对象
     *
     * @param source         源对象
     * @param targetSupplier 目标对象供应方
     * @param callBack       回调方法
     * @param <S>            源对象类型
     * @param <T>            目标对象类型
     * @return 目标对象
     */
    public static <S, T> T convertTo(S source, Supplier<T> targetSupplier, ConvertCallBack<S, T> callBack) throws InvocationTargetException, IllegalAccessException {
        if (null == source || null == targetSupplier) {
            return null;
        }

        T target = targetSupplier.get();
        copyProperties(source, target);
        if (callBack != null) {
            callBack.callBack(source, target);
        }
        return target;
    }

    public static <S, T> List<T> convertListTo(List<S> sources, Supplier<T> targetSupplier) throws InvocationTargetException, IllegalAccessException {
        return convertListTo(sources, targetSupplier, null);
    }

    /**
     * 转换对象
     *
     * @param sources        源对象list
     * @param targetSupplier 目标对象供应方
     * @param callBack       回调方法
     * @param <S>            源对象类型
     * @param <T>            目标对象类型
     * @return 目标对象list
     */
    public static <S, T> List<T> convertListTo(List<S> sources, Supplier<T> targetSupplier, ConvertCallBack<S, T> callBack) throws InvocationTargetException, IllegalAccessException {
        if (null == sources || null == targetSupplier) {
            return null;
        }

        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            T target = targetSupplier.get();
            copyProperties(source, target);
            if (callBack != null) {
                callBack.callBack(source, target);
            }
            list.add(target);
        }
        return list;
    }

    /**
     * 回调接口
     *
     * @param <S> 源对象类型
     * @param <T> 目标对象类型
     */
    @FunctionalInterface
    public interface ConvertCallBack<S, T> {
        void callBack(S t, T s);
    }
}
