# [15-1]
- 답: src 참조

- 해설: 두 번의 유효성 검사를 거친다.<br>
첫 번째는 커맨드 라인으로 받아들이는 배열의 범위와 관련한 예외와 parse관련 예외를 묶어 예시를 출력하고,<br>
두 번째로는 해당 파일의 존재 여부와 디렉터리가 아닌지를 확인해서 예외를 발생시킨다.

위 과정을 거치면 문자 기반 스트림인 FileReader와 보조 기반 스트림 BufferedReader를 생성해,<br>
해당 파일의 라인을 읽어낸다.

별도로 출력 라인의 숫자를 세기 위한 변수와 읽어낸 내용을 담기 위한 String 변수를 선언한 뒤,<br>
while문을 통해 커맨드라인으로 받은 숫자까지 해당 파일의 라인을 출력한다.

#[15-2]
- 답: src 참조

- 해설: 커맨드라인의 유효성 검사를 먼저 실행하고,<br>
위를 통과하면 해당 파일 객체를 만들어 이를 FileInputStream으로 읽게 한다.

PrintStream은 표준 출력인 System.out을 매개변수로 주고 생성한다.<br>
만약 다른 파일에 출력하게 할 거라면 매개변수로 그 파일 객체를 주면 된다.

유니코드를 담아낼 int변수를 새로 선언한 뒤,<br>
InputStream으로 read한 값을 그대로 printf의 지시자 %2x를 통해 16진수로 출력한다.

#[15-3]
- 답:

```
File[] files = dir.listFiles();

for(int i=0; i<files.length; i++) {
  if(files[i].isDirectory()) {
    totalDirs++;
    countFiles(files[i]);
  } else {
    totalFiles++;
    totalSize += files[i].length();
  }
}
```

#[15-4]
- 답: src 참조

- 해설: 분할된 걸 합치는 경우는 임시파일을 만들어 연이어 합치게 하는 방법도 있으나,<br>
이 문제의 경우는 하나의 파일이 분할된 게 아니라 여러 입력 스트림을 한꺼번에 처리하는 경우이므로,<br>
보조스트림인 sequenceInputStream이 더 간편하고 빠르다.

우선 유효성 검사로 Output의 대상이 되는 파일과 Input할 파일을 쓰도록 한 뒤,<br>
Enumeration을 반환하기 위한 Vector를 생성한다.

반복문을 통해 커맨드라인 배열에 저장된 파일 이름으로 객체를 만들고,<br>
exist()로 해당 파일이 실제로 존재하는지 확인한다.<br>
존재한다면 Vector에 추가하고 없으면 경고문을 출력한다.<br>
여기서 중요한 건 sequenceInputStream은 보조스트림이므로 Vector에 저장하는 건 기반스트림인 InputStream이란 것이다.<br>
File을 그대로 넣는 게 아니라 new FileInputStream을 만들어 넣는 걸 잊지 않도록 한다.

그 후, sequenceInputStream의 매개변수로 해당 Vector의 Enumeration을 넣은 뒤,
커맨드라인으로 받은 args[0]를 Output 대상으로 삼아 출력한다.

#[15-5]
- 답:

```
if(c == '<') inTag = true;

if(inTag) tmp.write(c);
else out.write(c);

if(c == '>') {
  inTag = false;
  tmp = new StringWriter();
}
```

- 해설: 태그가 시작될 시에는 inTag를 true로 바꾸고,<br>
태그가 끝날 시에는 false로 바꾸며 새로운 StringWirter를 만듦으로써 기존의 StringWriter에 저장된 내용을 버린다.

inTag의 값 여부에 따라 출력 대상이 바뀌는데,<br>
태그의 끝을 감지하는 if문을 밑에 배치함으로써 True일 때 >가 찍혀나오지 않도록 했다.

이 외에도 주목할 점은 close()에서 끝나기 직전,<br>
StringWriter안에 있는 StringBuffer 내용을 출력한다는 점이다.

#[15-6]
- 답:

```
if(subDir.equals("..")) {
  curDir = curDir.getParentFile();
} else if(subDir.equals(".")) {
  System.out.println(curDir);
} else {
  File sDir = new File(curDir, subDir);

  if(sDir.exists() && sDir.isDirectory()) curDir = sDir;
  else {
    System.out.println("유효하지 않은 디렉터리입니다");
    return;
  }
}
```

- 해설: 조상을 뜻하는 '..'의 경우, getParentFile()를 통해 조상의 파일을 받아 이를 현재 파일에 대입한다.<br>
'.'라면 그대로 현재 경로를 출력하고 그 외라면 subDir을 제목으로 새롭게 파일을 만든다.<br>
이때, 생성자의 매개변수로 현재 디렉터리를 줌으로써 현재 디렉터리가 조상이 되도록 한다.

exists()와 isDirectory()로 실제로 해당 파일이 존재하는지와 디렉터리인지를 확인한 뒤,<br>
이를 통과하면 대입하고 실패하면 경고문을 출력하고 return문으로 메서드를 종료시킨다.

#[15-7]
- 답:

```
if(!fileName.endsWith(".txt")) fileName = fileName+".txt";

File f = new File(fileName);

try(FileWriter fw = new FileWriter(f);
  BufferedWriter bw = new BufferedWriter(fw)) {
  if(!f.exists()) f.createNewFile();
  String line = ta.getText();

  bw.write(line);
} catch(IOException e) {
  e.printStackTrace();
}
```

- 해설: 저장을 txt 파일로 할 것이기에 매개변수로 받은 파일 이름이 .txt로 끝나는지 검사하고,<br>
txt 파일이 아니라면 뒤에 .txt를 추가해서 파일 형식을 결정지었다.

해당 파일의 객체를 만들어 exists()를 통해 그 파일이 실재하는지 확인한다.<br>
FileDialog클래스는 어디까지나 저장하는 경로만 정하는 것이고 해당 파일을 만들어주지는 않기 때문이다.<br>
고로 해당 메서드로 파일의 실제를 확인한 후, 존재하지 않으면 createNewFile()로 해당 이름의 파일을 새롭게 만들어준다.

이 객체를 대상으로 문자 기반 스트림인 FileWriter와 보조스트림인 BufferedWriter를 사용해,<br>
채팅창에 적힌 내용을 그대로 출력해준다.

여기서 주의할 점은 두 가지로,<br>
첫째는 채팅의 내용은 TextField가 아니라 TextArea에 존재하므로 ta로부터 getText()를 호출해야 한다는 것.<br>
둘째는 스트림을 닫는 close()를 try문에 적으면 예외가 발생할 시에 close()하지 못하는 경우가 있으므로,<br>
finally문을 따로 만들어 close()시켜야 한다는 점이다.

그러나 finally문으로 close()를 할 시에는 코드가 복잡해지고,<br>
close() 또한 IOException의 예외 처리가 필요해,<br>
여기서 예외가 발생하면 try문의 예외를 확인할 수 없다는 문제점이 있다.

이러한 이유로 본문에서는 단순한 try-catch-finally문이 아니라,<br>
자동으로 close해주는 try-with-resources문을 사용했다.<br>
try문 옆에 괄호로 두 문장 이상 넣을 경우 ';'로 구분해서 자동으로 닫을 스트림을 구별지어준다.<br>
덕분에 따로 close()를 호출하지 않더라도 경고가 뜨지 않게 되었다.

#[15-8]
- 답:

```
void display(int pos) {
  String word = wordList.get(pos);
  StringBuffer sb = new StringBuffer(word.length());
  StringTokenizer token = new StringTokenizer(word, "|");

  while(token.hasMoreTokens())
    sb.append(token.nextToken()+CR_LF);

  ta.append(sb.toString());
}

void loadFile(String fileName) {
  try(FileReader fr = new FileReader(new File(fileName));
    BufferedReader br = new BufferedReader(fr)){

    String line = "";

    while((line = br.readLine())!=null)
      wordList.add(line);
  } catch(Exception e) {
    System.out.println("유효하지 않은 파일입니다.");
    System.exit(1);
  }
}
```

- 해설: 우선 파일을 만들 때 try-with-resources문으로 작성했다.<br>
readLine()으로 해당 파일의 문장을 라인으로 읽어 ArrayList에 저장한다.<br>
만약 여기서 예외가 발생하면 경고문을 출력하고 시스템을 종료시킨다.

display()에서는 해당 위치(pos)에 있는 객체를 ArrayList로부터 얻어온다.<br>
지네릭스 타입이 <String>이므로 형변환하는 수고를 덜었다.<br>
StringBuffer와 StringTokenizer를 통해 |로 나누어 문장을 받아들이고,<br>
각 OS에 맞는 개행 문자를 더해 StringBuffer에 append시킨다.

마지막으로 StringBuffer의 내용을 TextArea에 append로 추가한다.

#[15-9]
- 답:

```
void fileOpen(String fileName) {
  String separator = System.getProperty("line.separator");

  try(BufferedReader br = new BufferedReader(new FileReader(fileName));
    StringWriter sw = new StringWriter()){

    String line = "";

    while((line = br.readLine())!=null) {
      sw.write(line);
      sw.write(separator);
    }

    content.append(sw.toString());

  } catch(IOException e) {
    e.printStackTrace();
  }
}

void saveAs(String fileName) {
  File f = new File(fileName);

  try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))){

    if(!f.exists()) f.createNewFile();
    String line = content.getText();

    bw.write(line);

  } catch(IOException e) {
    e.printStackTrace();
  }
}
```

- 해설: fileOpen의 경우, 해당 파일의 데이터를 읽어 출력하는 것이므로,<br>
FileReader와 BufferedReader를 사용해 대상 FileName을 매개변수로 파일 객체를 만들어 읽어냈다.

출력을 위해서 StringWriter를 사용했는데,<br>
일반적인 출력 방법을 이용할 경우 한 번에 처리되지 않고 한 글자씩 읽는다는 단점이 존재한다.<br>
StringReader/Writer는 내부에 StringBuffer가 있어 이를 통해 한 번에 처리하므로 이런 작업에 용이하다.
 
while문을 통해 읽어낸 라인을 Buffer에 append하는 과정에서,<br>
개행 문자로 줄을 나누게 했다.<br>
여기서 개행 문자는 어떤 OS에서도 대응할 수 있도록 System.getProperty를 통해 해당 OS에서의 개행 문자를 받아 사용한다.

saveAs()는 반대로 FileWriter와 BufferedWriter를 사용했다.<br>
주의점은 파일이 존재하지 않을 시에는 if문을 통해 새롭게 파일을 생성한다는 점이다.<br>
두 메서드 모두 try-with-resources문을 사용해 close()를 자동으로 호출한다는 것이고,<br>
입출력 대상을 TextArea인 content로 삼았다는 점이다.
