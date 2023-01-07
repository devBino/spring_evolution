package br.com.fbm.ceps.fbmceps.converter;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class ConverterVO {
    
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObject(O origin, Class<D> destination){
        return mapper.map(origin, destination);
    }

    public static <D, O> List<D> parseListObjects(List<O> originList, Class<D> destination){
        
        List<D> destinationObjects = new ArrayList<D>();

        for(O o : originList){
            destinationObjects.add( mapper.map(o, destination) );
        }

        return destinationObjects;
        
    }

}
