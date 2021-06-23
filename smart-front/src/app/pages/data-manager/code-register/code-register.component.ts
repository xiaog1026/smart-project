import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { CodeValueMasterVO } from 'app/model/code.value.master.vo';
import { CodeValueService } from 'app/services/code.value.service';
import { StrigUtil } from 'app/util/string-util';

@Component({
  selector: 'ngx-code-register',
  templateUrl: './code-register.component.html',
  styleUrls: ['./code-register.component.scss']
})
export class CodeRegisterComponent implements OnInit {

  constructor(private codeValueService: CodeValueService, private router: Router, private activeRoute: ActivatedRoute) { }
  codeValueMasterVO : CodeValueMasterVO = new CodeValueMasterVO();
  errorMsgs: string[];
  wordId: number;

  ngOnInit(): void {
    this.errorMsgs = [];
    this.activeRoute.queryParams.subscribe((params: Params) => {
    this.wordId = Number(params['id']);
    this.codeValueMasterVO.wordId = this.wordId;
    console.log("this.wordId:",this.wordId);
    });
  }

  registerCode(key:any){
    this.errorMsgs = [];
    if(!StrigUtil.isEmpty(this.codeValueMasterVO.codeId) && !StrigUtil.isEmpty(this.codeValueMasterVO.valuePhysicalName)){
      console.log(this.codeValueMasterVO.codeValue);
      this.codeValueService.registerCode(this.codeValueMasterVO).subscribe(() => {
        this.router.navigate(['/pages/code-view'],{queryParams:{id:key}});
      });
    } else {
      this.errorMsgs.push('データ名と属性を入力しなければなりません');
    }
  }
  clear(key:any){
    this.router.navigate(['/pages/code-view'],{queryParams:{id:key}});
  }


}
