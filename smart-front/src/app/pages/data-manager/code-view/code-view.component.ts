import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { WordDictionaryVO } from 'app/model/word.dictionary.vo';
import { DataService } from 'app/services/data.service';
import { FormsModule } from '@angular/forms';
import { CodeValueMasterVO } from 'app/model/code.value.master.vo';
import { CodeValueService } from 'app/services/code.value.service';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { StrigUtil } from 'app/util/string-util';

@Component({
  selector: 'ngx-code-view',
  templateUrl: './code-view.component.html',
  styleUrls: ['./code-view.component.scss']
})
export class CodeViewComponent implements OnInit {

  modalRef: NgbModalRef;
  codeValueMaster: any;

  constructor(private modal: NgbModal ,private dataService: DataService,private codeValueService: CodeValueService,private router : Router,private activeRoute: ActivatedRoute) { }
  wordId: number;
  allChecked: false;
  errorMsgs: string[];
  CodeValueMasterList: CodeValueMasterVO[];
  wordDictionaryVO: WordDictionaryVO = new WordDictionaryVO();
  codeValueMasterVO : CodeValueMasterVO = new CodeValueMasterVO();
  

  ngOnInit(): void {
    this.errorMsgs = [];
    this.activeRoute.queryParams.subscribe((params: Params) => {
     
        if (params['id'] != null) {
          this.wordId = Number(params['id']);
          console.log(this.wordId);
          this.dataService.selectWordBywordId(this.wordId).subscribe(resData => {
            this.wordDictionaryVO = resData.result;
            console.log('wordDictionaryVO', this.wordDictionaryVO);
          });
          this.codeValueService.selectCodeBywordId(this.wordId).subscribe(resData => {
            this.CodeValueMasterList = resData.result;
            console.log('CodeValueMasterList', this.CodeValueMasterList);
          });
        }; 
      },
      error => {
        console.log("wordId is null");
      },
    );
  }


  toRegister(key:any) {
    this.router.navigate(['pages/code-register'],{queryParams:{id:key}});
  }

  toModify(key:any) {
    this.router.navigate(['pages/code-modify'],{queryParams:{id:key}});
  }

  toDelete(key:any) {
    this.router.navigate(['pages/code-modify'],{queryParams:{id:key}});
  }
  toSelect(key:CodeValueMasterVO[]){
    console.log("checkboxtest");
    this.activeRoute.queryParams.subscribe((params: Params) => {

      for(this.codeValueMaster in this.CodeValueMasterList){
        console.log(this.CodeValueMasterList);
      }
    });
  }

  openModal(key:any,popup:any){
    this.modalRef = this.modal.open(popup,{size:'lg'});
    this.codeValueMasterVO.codeId = null;
    this.codeValueMasterVO.wordId = key;
    this.codeValueMasterVO.codeNo = null;
    this.codeValueMasterVO.description = null;
    this.codeValueMasterVO.valueLogicName = null;
    this.codeValueMasterVO.valuePhysicalName = null;
    
  }

  openModal2(key:any,popup:any){
    this.modalRef = this.modal.open(popup,{size:'lg'});
    this.codeValueMasterVO.wordId = key;
    this.codeValueService.selectCodeByCodeId(key).subscribe(resData => {
      this.codeValueMasterVO = resData.result;
      console.log('codeValueMasterVO', this.codeValueMasterVO);
    });
  }

  registerCode(key:any){
    this.errorMsgs = [];
    if(!StrigUtil.isEmpty(this.codeValueMasterVO.codeId) && !StrigUtil.isEmpty(this.codeValueMasterVO.valuePhysicalName)){
      console.log(this.codeValueMasterVO.codeValue);
      this.codeValueService.registerCode(this.codeValueMasterVO).subscribe(() => {
        this.modalRef.close();
        this.wordId = this.codeValueMasterVO.wordId;
        console.log(this.wordId);
        this.dataService.selectWordBywordId(this.wordId).subscribe(resData => {
          this.wordDictionaryVO = resData.result;
          console.log('wordDictionaryVO', this.wordDictionaryVO);
        });
        this.codeValueService.selectCodeBywordId(this.wordId).subscribe(resData => {
          this.CodeValueMasterList = resData.result;
          console.log('CodeValueMasterList', this.CodeValueMasterList);
        });
      });
    } else {
      this.errorMsgs.push('データ名と属性を入力しなければなりません');
    }
  }
  modifyCode(){
    this.errorMsgs = [];
    if(!StrigUtil.isEmpty(this.codeValueMasterVO.codeId) && !StrigUtil.isEmpty(this.codeValueMasterVO.valuePhysicalName)){
      console.log(this.codeValueMasterVO.codeValue);
      this.codeValueService.modifyCode(this.codeValueMasterVO).subscribe(resData => {
        if(resData.result === 0){
          this.errorMsgs.push('このコードデータは存在しません');
        }else{
          this.modalRef.close();
          this.wordId = this.codeValueMasterVO.wordId;
          console.log(this.wordId);
          this.dataService.selectWordBywordId(this.wordId).subscribe(resData => {
            this.wordDictionaryVO = resData.result;
            console.log('wordDictionaryVO', this.wordDictionaryVO);
          });
          this.codeValueService.selectCodeBywordId(this.wordId).subscribe(resData => {
            this.CodeValueMasterList = resData.result;
            console.log('CodeValueMasterList', this.CodeValueMasterList);
          });        }
      });
    } else {
      this.errorMsgs.push('データ名と属性を入力しなければなりません');
    }
  }

  deleteCode(){
    this.errorMsgs = [];
    if(!StrigUtil.isEmpty(this.codeValueMasterVO.codeId) && !StrigUtil.isEmpty(this.codeValueMasterVO.valuePhysicalName)){
      console.log(this.codeValueMasterVO.codeValue);
      this.codeValueService.deleteCode(this.codeValueMasterVO).subscribe(resData => {
        if(resData.result === 0){
          this.errorMsgs.push('このコードデータは存在しません');
        }else{
          this.modalRef.close();
          this.wordId = this.codeValueMasterVO.wordId;
          console.log(this.wordId);
          this.dataService.selectWordBywordId(this.wordId).subscribe(resData => {
            this.wordDictionaryVO = resData.result;
            console.log('wordDictionaryVO', this.wordDictionaryVO);
          });
          this.codeValueService.selectCodeBywordId(this.wordId).subscribe(resData => {
            this.CodeValueMasterList = resData.result;
            console.log('CodeValueMasterList', this.CodeValueMasterList);
          });        }
      });
    } else {
      this.errorMsgs.push('データ名と属性を入力しなければなりません');
    }
  }
  clear(){
    this.modalRef.close();
  }

  dataBack(){
    this.router.navigate(['pages/data-view']);
  }
}

