import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { WordDictionaryVO } from 'app/model/word.dictionary.vo';
import { DataService } from 'app/services/data.service';
import { FormsModule } from '@angular/forms';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { StrigUtil } from 'app/util/string-util';

@Component({
  selector: 'ngx-data-view',
  templateUrl: './data-view.component.html',
  styleUrls: ['./data-view.component.scss']
})
export class DataDetailComponent implements OnInit {

  upComing: any[] = [];

  searchString = '';
  option = 'option1';
  modalRef: NgbModalRef;


  WordDictionaryList: WordDictionaryVO[];

  constructor(private modal: NgbModal ,private dataService: DataService,private router : Router) { }

  wordDictionaryVO: WordDictionaryVO = new WordDictionaryVO();
  errorMsgs: string[];


  ngOnInit() {
    this.search();
  }


  search() {
    const searchParameter = {
      queryOption: this.option,
      keyWord: this.searchString
    };
    this.dataService.searchDatas(searchParameter).subscribe(resData => {
      this.WordDictionaryList = resData.result;
      console.log('WordDictionaryList', this.WordDictionaryList);
    });
  }

  toRegister(popup1:any) {
    this.modalRef = this.modal.open(popup1,{size:'lg'});
  }

  toModify(key:any,popup2:any) {
    this.modalRef = this.modal.open(popup2,{size:'lg'});
    this.wordDictionaryVO.wordId = key;
    this.dataService.selectWordBywordId(this.wordDictionaryVO.wordId).subscribe(resData => {
      this.wordDictionaryVO = resData.result;
      console.log('wordDictionaryVO', this.wordDictionaryVO);
    });
  }

  toModifyCode(key:any){
    this.router.navigate(['pages/code-view'],{queryParams:{id:key}});
  }

  wordLengthDisabledForType(): boolean {
    const wordType = this.wordDictionaryVO.wordType;
    if (wordType==='float'||wordType==='double'||wordType==='int'||wordType==='long'){
      return false;
    }else{
      this.wordDictionaryVO.wordLength=null;
      return true;
    }
  }

  wordDecimalDisabledForType(): boolean {
    const wordType = this.wordDictionaryVO.wordType;
    if (wordType==='float'||wordType==='double'){
      return false;
    }else{
      this.wordDictionaryVO.wordDecimal=null;
      return true;
    }
  }

  reset(){
    this.modalRef.close();
    this.search;
  }

  registerDatas(){
    this.errorMsgs = [];
    if(!StrigUtil.isEmpty(this.wordDictionaryVO.physicalName) && !StrigUtil.isEmpty(this.wordDictionaryVO.wordType)){
      this.dataService.registerDatas(this.wordDictionaryVO).subscribe(() => {
        this.modalRef.close();
        this.search;
      });
    } else {
      this.errorMsgs.push('データ名と属性を入力しなければなりません');
    }
  }

  dataToModify(){
    this.errorMsgs = [];
    if(!StrigUtil.isEmpty(this.wordDictionaryVO.physicalName) && !StrigUtil.isEmpty(this.wordDictionaryVO.wordType)){
      this.dataService.modifyDatas(this.wordDictionaryVO).subscribe(() => {
        this.modalRef.close();
        this.search();
      });
    } else {
      this.errorMsgs.push('データ名と属性を入力しなければなりません');
    }
  }
}

