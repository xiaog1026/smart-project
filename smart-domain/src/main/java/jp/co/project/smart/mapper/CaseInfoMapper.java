package jp.co.project.smart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;

import jp.co.project.smart.model.CaseDto;
import jp.co.project.smart.model.SearchCaseDto;
import jp.co.project.smart.model.SearchResultDto;

@Mapper
public interface CaseInfoMapper {

	@Insert("INSERT INTO case_info (shopCode,shopName,chargeName,debateKbn,finishKbn,caseNum, startDate, taskKbn, name, furigana, customNum,cifNum,careerKbn,sex,birth,age,postNum,address,phoneNum,searchDate,endDate,file1Name,file2Name,file1Url,file2Url,file1Type,file2Type)  VALUES (#{shopCode},#{shopName},#{chargeName},#{debateKbn},#{finishKbn},#{caseNum}, #{startDate}, #{taskKbn}, #{name}, #{furigana}, #{customNum}, #{cifNum},#{careerKbn},#{sex},#{birth},#{age},#{postNum},#{address},#{phoneNum},#{searchDate},#{endDate},#{file1Name},#{file2Name},#{file1Url},#{file2Url},#{file1Type},#{file2Type});")
	@Options(useGeneratedKeys = true)
	Integer save(CaseDto caseDto);

	@SelectProvider(type = CaseDaoProvider.class, method = "searchCaseInfos")
	List<SearchResultDto> searchCaseByCondition(SearchCaseDto caseDto);

	@Delete("DELETE from case_info WHERE id = #{id}")
	void delete(int id);

	@Select("SELECT * from case_info WHERE id = #{id}")
	CaseDto getCaseById(int id);

	
	@Update("UPDATE case_info set shopCode = #{shopCode},shopName = #{shopName},chargeName = #{chargeName},debateKbn = #{debateKbn},finishKbn = #{finishKbn},caseNum = #{caseNum},startDate = #{startDate},taskKbn = #{taskKbn},name = #{name},furigana = #{furigana},customNum = #{customNum},cifNum = #{cifNum},careerKbn = #{careerKbn},sex = #{sex},birth = #{birth},age = #{age},postNum = #{postNum},address = #{address},phoneNum = #{phoneNum},searchDate = #{searchDate},endDate = #{endDate},file1Name = #{file1Name},file2Name = #{file2Name},file1Url = #{file1Url},file2Url = #{file2Url},file1Type = #{file1Type},file2Type = #{file2Type} WHERE id = #{id}")
	int update(CaseDto caseDto);
	
	class CaseDaoProvider {
		public String searchCaseInfos(SearchCaseDto caseDto) {
			return new SQL() {
				{
					SELECT("*");
					FROM("case_info");
					if (caseDto.getShopCode() != null && !caseDto.getShopCode().isEmpty()) {
						WHERE("shopCode like concat('%',#{shopCode},'%')");
					}
					if (caseDto.getShopName() != null && !caseDto.getShopName().isEmpty()) {
						WHERE("shopName like concat('%',#{shopName},'%')");
					}
					// TODO
					if (caseDto.getChargeName() != null && !caseDto.getChargeName().isEmpty()) {
						WHERE("chargeName like concat('%',#{chargeName},'%')");
					}
					if (caseDto.getWillName() != null && !caseDto.getWillName().isEmpty()) {
						WHERE("name like concat('%',#{willName},'%')");
					}
					if (caseDto.getCifNum() != null && !caseDto.getCifNum().isEmpty()) {
						WHERE("cifNum like concat('%',#{cifNum},'%')");
					}
					// TODO
					if (caseDto.getDebateKbn() != null && !caseDto.getDebateKbn().isEmpty()) {
						WHERE("debateKbn like concat('%',#{debateKbn},'%')");
					}
					// TODO
					if (caseDto.getFinishKbn() != null && !caseDto.getFinishKbn().isEmpty()) {
						WHERE("finishKbn like concat('%',#{finishKbn},'%')");
					}
					if (caseDto.getBusinessType() != null && !caseDto.getBusinessType().isEmpty()) {
						WHERE("careerKbn like concat('%',#{businessType},'%')");
					}
					//DATE FROM
					if (caseDto.getFixDateFrom() != null) {
						WHERE("startDate >= #{fixDateFrom}");
					}
					//DATE TO
					if (caseDto.getFixDateTo() != null) {
						WHERE("startDate <= #{fixDateTo}");
					}
				}
			}.toString();
		}
	}
}
