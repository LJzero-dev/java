class StringEx2 {
	public static void main(String[] args) {
		String file1 = "test.jpg";	String file2 = "test.gif";
		String file3 = "test.doc";	String file4 = "test.zip";

		imgFile(file1);	imgFile(file2);	imgFile(file3);	imgFile(file4);
	}

	public static void imgFile(String file) {
	file = file.toLowerCase();
	String imgExtension ="jpg|gif|png|jpeg";
	boolean isImg = true;
	if(imgExtension.indexOf(file.substring(file.lastIndexOf('.')+1,file.length()))==-1){isImg=!isImg;}
		
		if(isImg){
			System.out.println("파일명" + file + "은 이미지 파일이 맞습니다.");
		}else{
			System.out.println("파일명" + file + "은 이미지 파일이 아닙니다.");
		}
	}
	

	/* 받아온 파일명 문자열을 이용하여 이미지 파일인지 검사한 후 출력하는 메소드
	파일명에서 확장자를 추출하여 이미지파일 확장자인지 여부를 검사
	1. 파일명에서 확장자 부분만 추출
	 - 마지막 점의 다음 글자부터 끝까지 잘라옴 : 마지막 점(lastIndexOf()), 자름(substring())
	2. 추출한 확장자가 이미지 파일의 확장자인지 검사 후 출력
	 - 이미지 확장자 : jpg, gif, png, jpeg
	 - 출력 메시지
		파일명 + '은(는) 이미지 파일이 맞습니다.'
		파일명 + '은(는) 이미지 파일이 아닙니다.'
	*/
	}

