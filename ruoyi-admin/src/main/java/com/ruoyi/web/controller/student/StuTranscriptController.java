package com.ruoyi.web.controller.student;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.StuTranscript;
import com.ruoyi.system.service.IStuTranscriptService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 成绩Controller
 * 
 * @author SZF
 * @date 2024-12-04
 */
@RestController
@RequestMapping("/system/transcript")
public class StuTranscriptController extends BaseController
{
    @Autowired
    private IStuTranscriptService stuTranscriptService;

    /**
     * 查询成绩列表
     */
    @PreAuthorize("@ss.hasPermi('system:transcript:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuTranscript stuTranscript)
    {
        startPage();
        List<StuTranscript> list = stuTranscriptService.selectStuTranscriptList(stuTranscript);
        return getDataTable(list);
    }

    /**
     * 导出成绩列表
     */
    @PreAuthorize("@ss.hasPermi('system:transcript:export')")
    @Log(title = "成绩", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuTranscript stuTranscript)
    {
        List<StuTranscript> list = stuTranscriptService.selectStuTranscriptList(stuTranscript);
        ExcelUtil<StuTranscript> util = new ExcelUtil<StuTranscript>(StuTranscript.class);
        util.exportExcel(response, list, "成绩数据");
    }

    /**
     * 获取成绩详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:transcript:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(stuTranscriptService.selectStuTranscriptById(id));
    }

    /**
     * 新增成绩
     */
    @PreAuthorize("@ss.hasPermi('system:transcript:add')")
    @Log(title = "成绩", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuTranscript stuTranscript)
    {
        return toAjax(stuTranscriptService.insertStuTranscript(stuTranscript));
    }

    /**
     * 修改成绩
     */
    @PreAuthorize("@ss.hasPermi('system:transcript:edit')")
    @Log(title = "成绩", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuTranscript stuTranscript)
    {
        return toAjax(stuTranscriptService.updateStuTranscript(stuTranscript));
    }

    /**
     * 删除成绩
     */
    @PreAuthorize("@ss.hasPermi('system:transcript:remove')")
    @Log(title = "成绩", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stuTranscriptService.deleteStuTranscriptByIds(ids));
    }
}
