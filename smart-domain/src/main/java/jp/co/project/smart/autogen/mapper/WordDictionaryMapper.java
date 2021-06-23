package jp.co.project.smart.autogen.mapper;

import java.util.List;
import jp.co.project.smart.autogen.model.WordDictionary;
import jp.co.project.smart.autogen.model.WordDictionaryExample;
import org.apache.ibatis.annotations.Param;

public interface WordDictionaryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    long countByExample(WordDictionaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    int deleteByExample(WordDictionaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    int deleteByPrimaryKey(Integer wordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    int insert(WordDictionary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    int insertSelective(WordDictionary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    List<WordDictionary> selectByExample(WordDictionaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    WordDictionary selectByPrimaryKey(Integer wordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    int updateByExampleSelective(@Param("record") WordDictionary record, @Param("example") WordDictionaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    int updateByExample(@Param("record") WordDictionary record, @Param("example") WordDictionaryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    int updateByPrimaryKeySelective(WordDictionary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    int updateByPrimaryKey(WordDictionary record);
}