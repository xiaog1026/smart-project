import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { CodeValueMasterVO } from 'app/model/code.value.master.vo';
import { CodeValueService } from 'app/services/code.value.service';
import { StrigUtil } from 'app/util/string-util';

@Component({
  selector: 'ngx-code-modify',
  templateUrl: './code-modify.component.html',
  styleUrls: ['./code-modify.component.scss']
})
export class CodeModifyComponent implements OnInit {

  constructor(private codeValueService: CodeValueService, private router: Router, private activeRoute: ActivatedRoute) { }
  codeValueMasterVO : CodeValueMasterVO = new CodeValueMasterVO();
  errorMsgs: string[];
  codeId: number;

  ngOnInit(): void {
    this.errorMsgs = [];
    this.activeRoute.queryParams.subscribe((params: Params) => {
    this.codeId = Number(params['id']);
    this.codeValueService.selectCodeByCodeId(this.codeId).subscribe(resData => {
      this.codeValueMasterVO = resData.result;
      console.log('codeValueMasterVO', this.codeValueMasterVO);
    });
    console.log("this.wordId:",this.codeValueMasterVO.wordId);
    });
  }

  registerCode(){
    this.errorMsgs = [];
    if(!StrigUtil.isEmpty(this.codeValueMasterVO.codeId) && !StrigUtil.isEmpty(this.codeValueMasterVO.valuePhysicalName)){
      console.log(this.codeValueMasterVO.codeValue);
      this.codeValueService.modifyCode(this.codeValueMasterVO).subscribe(resData => {
        if(resData.result === 0){
          this.errorMsgs.push('このコードデータは存在しません');
        }else{
          this.router.navigate(['/pages/code-view'],{queryParams:{id:this.codeValueMasterVO.wordId}});
        }
      });
    } else {
      this.errorMsgs.push('データ名と属性を入力しなければなりません');
    }
  }
  clear(key:any){
    this.router.navigate(['/pages/code-view'],{queryParams:{id:key}});
  }

  deleteCode(){
    this.errorMsgs = [];
    if(!StrigUtil.isEmpty(this.codeValueMasterVO.codeId) && !StrigUtil.isEmpty(this.codeValueMasterVO.valuePhysicalName)){
      console.log(this.codeValueMasterVO.codeValue);
      this.codeValueService.deleteCode(this.codeValueMasterVO).subscribe(resData => {
        if(resData.result === 0){
          this.errorMsgs.push('このコードデータは存在しません');
        }else{
          this.router.navigate(['/pages/code-view'],{queryParams:{id:this.codeValueMasterVO.wordId}});
        }
      });
    } else {
      this.errorMsgs.push('データ名と属性を入力しなければなりません');
    }
  }


}
