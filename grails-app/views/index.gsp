<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<title>Woingenau Test Server</title>
<asset:stylesheet src="main.css"/>
</head>

<body>
<article class="markdown-body">
    <h1>Test-Server (Woingenau Backend)</h1>
    <h3><a href="http://thawing-stream-9266.herokuapp.com/">http://thawing-stream-9266.herokuapp.com/</a></h3>
    <h2>|   GET    | /courses                                        | Action: index            | </h2>
    <p>Liefert - Liste (format unten):</p>
    <h2></a>|   GET    | /courses/${'${id}'} |Action: show|</h2>
    <p>Liefert ein Element</p>
<div class="highlight"><pre><span class="p">{</span>
  <span class="nt">&quot;id&quot;</span><span class="p">:</span><span class="mi">1</span><span class="p">,</span>
  <span class="nt">&quot;appointments&quot;</span><span class="p">:[</span>
    <span class="p">{</span>
      <span class="nt">&quot;id&quot;</span><span class="p">:</span><span class="mi">1</span><span class="p">,</span>
      <span class="nt">&quot;place&quot;</span><span class="p">:</span><span class="s2">&quot;Empire&quot;</span><span class="p">,</span>
      <span class="nt">&quot;start&quot;</span><span class="p">:</span><span class="s2">&quot;2014-12-08T20:21:03Z&quot;</span><span class="p">,</span>
      <span class="nt">&quot;end&quot;</span><span class="p">:</span><span class="s2">&quot;2014-12-08T20:21:03Z&quot;</span>
    <span class="p">}</span>
  <span class="p">],</span>
  <span class="nt">&quot;creator&quot;</span><span class="p">:{</span>
    <span class="nt">&quot;id&quot;</span><span class="p">:</span><span class="mi">1</span>
  <span class="p">},</span>
  <span class="nt">&quot;lecturer&quot;</span><span class="p">:{</span>
    <span class="nt">&quot;id&quot;</span><span class="p">:</span><span class="mi">2</span>
  <span class="p">},</span>
  <span class="nt">&quot;members&quot;</span><span class="p">:[</span>
    <span class="p">{</span>
      <span class="nt">&quot;id&quot;</span><span class="p">:</span><span class="mi">2</span>
    <span class="p">},</span>
    <span class="p">{</span>
      <span class="nt">&quot;id&quot;</span><span class="p">:</span><span class="mi">3</span>
    <span class="p">},</span>
    <span class="p">{</span>
      <span class="nt">&quot;id&quot;</span><span class="p">:</span><span class="mi">1</span>
    <span class="p">}</span>
  <span class="p">],</span>
  <span class="nt">&quot;title&quot;</span><span class="p">:</span><span class="s2">&quot;The Force 101&quot;</span>
<span class="p">}</span>
</pre></div>



    <h2>|   POST   | /courses                                                  | Action: save             |
    </h2>
<div class="highlight"><pre><span class="p">{</span>
  <span class="nt">&quot;appointments&quot;</span><span class="p">:[</span>
    <span class="p">{</span>
      <span class="nt">&quot;place&quot;</span><span class="p">:</span><span class="s2">&quot;Earth&quot;</span><span class="p">,</span>
      <span class="nt">&quot;start&quot;</span><span class="p">:</span><span class="s2">&quot;2014-12-08T20:21:03Z&quot;</span><span class="p">,</span>
      <span class="nt">&quot;end&quot;</span><span class="p">:</span><span class="s2">&quot;2014-12-08T20:21:03Z&quot;</span>
    <span class="p">}</span>
  <span class="p">],</span>
  <span class="nt">&quot;creator&quot;</span><span class="p">:{</span>
    <span class="nt">&quot;id&quot;</span><span class="p">:</span><span class="mi">1</span>
  <span class="p">},</span>
  <span class="nt">&quot;lecturer&quot;</span><span class="p">:{</span>
    <span class="nt">&quot;id&quot;</span><span class="p">:</span><span class="mi">2</span>
  <span class="p">},</span>
  <span class="nt">&quot;members&quot;</span><span class="p">:[</span>
    <span class="p">{</span>
      <span class="nt">&quot;id&quot;</span><span class="p">:</span><span class="mi">2</span>
    <span class="p">},</span>
    <span class="p">{</span>
      <span class="nt">&quot;id&quot;</span><span class="p">:</span><span class="mi">3</span>
    <span class="p">},</span>
    <span class="p">{</span>
      <span class="nt">&quot;id&quot;</span><span class="p">:</span><span class="mi">1</span>
    <span class="p">}</span>
  <span class="p">],</span>
  <span class="nt">&quot;title&quot;</span><span class="p">:</span><span class="s2">&quot;The Force 101&quot;</span>
<span class="p">}</span>
</pre></div>
    <p>Speichert ein neuer Course in der DB</p>

    <h2>|   PUT    | /courses/${'${id}'}                                            | Action: update           |</h2>
<div class="highlight"><pre><span class="p">{</span>
  <span class="nt">&quot;creator&quot;</span><span class="p">:{</span>
    <span class="nt">&quot;id&quot;</span><span class="p">:</span><span class="mi">1</span>
  <span class="p">},</span>
  <span class="nt">&quot;lecturer&quot;</span><span class="p">:{</span>
    <span class="nt">&quot;id&quot;</span><span class="p">:</span><span class="mi">2</span>
  <span class="p">},</span>
  <span class="nt">&quot;title&quot;</span><span class="p">:</span><span class="s2">&quot;The Force 102&quot;</span>
<span class="p">}</span>
</pre></div>




    <h2>
         </a>|   GET    | /courses/${'${courseId}'}/members                              | Action: index            |
    </h2>
<div class="highlight"><pre><span class="p">[</span>
  <span class="p">{</span>
    <span class="nt">&quot;id&quot;</span><span class="p">:</span><span class="mi">3</span><span class="p">,</span>
    <span class="nt">&quot;username&quot;</span><span class="p">:</span><span class="s2">&quot;hans&quot;</span><span class="p">,</span>
    <span class="nt">&quot;firstname&quot;</span><span class="p">:</span><span class="s2">&quot;hans&quot;</span><span class="p">,</span>
    <span class="nt">&quot;lastname&quot;</span><span class="p">:</span><span class="s2">&quot;hodor&quot;</span><span class="p">,</span>
    <span class="nt">&quot;enabled&quot;</span><span class="p">:</span><span class="kc">true</span>
  <span class="p">},</span>
  <span class="p">{</span>
    <span class="nt">&quot;id&quot;</span><span class="p">:</span><span class="mi">1</span><span class="p">,</span>
    <span class="nt">&quot;username&quot;</span><span class="p">:</span><span class="s2">&quot;jack&quot;</span><span class="p">,</span>
    <span class="nt">&quot;firstname&quot;</span><span class="p">:</span><span class="s2">&quot;jack&quot;</span><span class="p">,</span>
    <span class="nt">&quot;lastname&quot;</span><span class="p">:</span><span class="s2">&quot;bauer&quot;</span><span class="p">,</span>
    <span class="nt">&quot;enabled&quot;</span><span class="p">:</span><span class="kc">true</span>
  <span class="p">},</span>
  <span class="p">{</span>
    <span class="nt">&quot;id&quot;</span><span class="p">:</span><span class="mi">2</span><span class="p">,</span>
    <span class="nt">&quot;username&quot;</span><span class="p">:</span><span class="s2">&quot;joda&quot;</span><span class="p">,</span>
    <span class="nt">&quot;firstname&quot;</span><span class="p">:</span><span class="s2">&quot;joda&quot;</span><span class="p">,</span>
    <span class="nt">&quot;lastname&quot;</span><span class="p">:</span><span class="s2">&quot;maier&quot;</span><span class="p">,</span>
    <span class="nt">&quot;enabled&quot;</span><span class="p">:</span><span class="kc">true</span>
  <span class="p">}</span>
<span class="p">]</span>
</pre></div>
    <p>enabled: true|false ist ob der user freigeschaltet ist. Sollte euch nicht interessieren</p>

    <h2>
        <a id="user-content----post----coursescourseidmembers-------------------------------action-save-------------"
           class="anchor"
           href="#---post----coursescourseidmembers-------------------------------action-save-------------"
           aria-hidden="true"><span class="octicon octicon-link"></span>
        </a>|   POST   | /courses/${'${courseId}'}/members                              | Action: save             |
    </h2>

    <p>Fügt ein neue User zum Course</p>

<div class="highlight"><pre><span class="p">{</span>
<span class="nt">&quot;id&quot;</span><span class="p">:</span> <span class="mi">3</span>
<span class="p">}</span>
</pre></div>


    <h2>
        <a id="user-content---delete---coursescourseidmembers-action-delete" class="anchor"
           href="#--delete---coursescourseidmembers-action-delete" aria-hidden="true"><span
                class="octicon octicon-link"></span>
        </a>|  DELETE  | /courses/'${'${courseId}'}/members |Action: delete|</h2>

    <p>Analog zu save</p>

    <h2>
        <a id="user-content-es-gilt---action-save-ist-keine-id-notwendig-es-wird-generiert"
           class="anchor" href="#es-gilt---action-save-ist-keine-id-notwendig-es-wird-generiert"
           aria-hidden="true"><span class="octicon octicon-link"></span>
        </a>Es gilt--&gt; Action: save ist keine id notwendig, es wird generiert</h2>

</article>
</body>
</html>