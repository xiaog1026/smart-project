import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CodeModifyComponent } from './code-modify.component';

describe('CodeModifyComponent', () => {
  let component: CodeModifyComponent;
  let fixture: ComponentFixture<CodeModifyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CodeModifyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CodeModifyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
